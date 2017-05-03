package com.music.web.bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.music.web.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 赵文奕 on 2017/2/27.
 */
@Component
@EnableWebMvc
public class MyWebSocketHandler implements WebSocketHandler {

    private static  final Logger logger = LoggerFactory.getLogger(MyHandShakeInterceptor.class);

    //当类加载过程中会生成该类
    public static  final Map<Long,WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new HashMap<Long, WebSocketSession>();
    }

    //在客户端和服务器端建立连接后
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        Long uid = (Long) webSocketSession.getAttributes().get("uid");
        if(userSocketSessionMap.get(uid) == null){
            userSocketSessionMap.put(uid,webSocketSession);
        }
    }

    //发送消息前的处理
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        if(webSocketMessage.getPayloadLength() == 0){
            return;
        }

        //从socket通道中获取数据并转化成Message对象
        Message message = new Gson().fromJson(webSocketMessage.getPayload().toString(),Message.class);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        message.setMessageDate(currentTime);
        logger.info("来自客户端的消息message="+message);

        //TODO 将message存储在数据库中

        //发送信息
        sendMessageToUser(message.getToId(),new TextMessage(new GsonBuilder().setDateFormat
                ("yyyy-MM-dd HH:mm:ss").create().toJson(message)));

    }

    //在传输过程中遇到错误后
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    //在连接关闭后的操作
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        Iterator<Map.Entry<Long,WebSocketSession>> iterator = userSocketSessionMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long,WebSocketSession> entry = iterator.next();
            if(entry.getValue().getAttributes().get("uid") == webSocketSession.getAttributes().get("uid")){
                userSocketSessionMap.remove(webSocketSession.getAttributes().get("uid"));
                logger.info("用户"+webSocketSession.getAttributes().get("uid")+"关闭连接");
            }
        }

    }

    //发送消息
    public boolean supportsPartialMessages() {
        return false;
    }

    //发送信息的实现
    public void sendMessageToUser(Long uid, TextMessage message){
        WebSocketSession socketSession = userSocketSessionMap.get(uid);
        if(null != socketSession && socketSession.isOpen()){
            try {
                socketSession.sendMessage(message);
            }catch (Exception ex){
                logger.error("发送消息的出现异常ex"+ex);
            }

        }
    }
}
