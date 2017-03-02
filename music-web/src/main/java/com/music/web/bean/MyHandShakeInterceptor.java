package com.music.web.bean;

import com.music.web.constant.CommonConstants;
import com.music.web.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 赵文奕 on 2017/2/27.
 * webSocket 握手拦截器
 * 拦截握手前，握手后的的两个切面
 */
public class MyHandShakeInterceptor implements HandshakeInterceptor {

    private static  final Logger logger = LoggerFactory.getLogger(MyHandShakeInterceptor.class);

    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if(serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session = servletRequest.getServletRequest().getSession(false);

            //对用户进行标记
            User user = (User)session.getAttribute(CommonConstants.CURRENT_USER);
            if(null != user){
                map.put("uid",user.getId());//为服务器建立webSocketSession做准备
                logger.info("用户-"+user.getUsername()+"-建立了连接");
            }else {
                return false;
            }
        }
        return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
