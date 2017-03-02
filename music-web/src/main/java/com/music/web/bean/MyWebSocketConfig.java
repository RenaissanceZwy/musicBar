package com.music.web.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by 赵文奕 on 2017/2/27.
 */
@Component
@Configuration
@EnableWebSocket
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {



    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry){

        //添加webSocket处理器，添加webSocket拦截器
        webSocketHandlerRegistry.addHandler(myHandler(),"/ws").addInterceptors(new MyHandShakeInterceptor());

        webSocketHandlerRegistry.addHandler(myHandler(),"/ws/sockjs").addInterceptors(new MyHandShakeInterceptor()).withSockJS();


    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyWebSocketHandler();
    }
}
