package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.entity.User;
import com.music.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 聊天功能
 * Created by zhaowenyi on 2017/4/24.
 */
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/room")
    public String test2(HttpServletRequest request, Model model, HttpServletResponse response,
                        @RequestParam(required = true ,value = "toId") Integer toId){
        User user = (User)request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(null == user){
            return "404";
        }
        //获取当前对话的用户
        User toUser = userService.getUserById(toId.toString());
        model.addAttribute("toUser",toUser);

        return "room";
    }
}
