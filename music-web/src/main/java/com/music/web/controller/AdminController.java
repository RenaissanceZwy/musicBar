package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.entity.User;
import com.music.web.service.CommentService;
import com.music.web.service.UserService;
import com.music.web.vo.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 赵文奕 on 2016/11/23.
 * 后台管理界面
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    /**
     * 主页显示
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        model.addAttribute("user",user);

        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);

        /*获取所有的用户*/
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin";
    }


    @RequestMapping(value = "/test")
    public String test2(HttpServletRequest request,HttpServletResponse response,Model model,
                        @RequestParam(required = true ,value = "toId") Integer toId){
        //获取当前登录的用户
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        //获取当前对话的用户
        User toUser = userService.getUserById(toId.toString());

        model.addAttribute("toUser",toUser);
        model.addAttribute("user",user);
        return "test";
    }


}
