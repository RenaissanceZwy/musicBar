package com.music.web.controller;

import com.music.web.entity.User;
import com.music.web.service.CommentService;
import com.music.web.service.UserService;
import com.music.web.vo.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;
    /*主页显示*/
    @RequestMapping(value = "/index")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model){
        User user = (User) request.getSession().getAttribute("currentUser");
        model.addAttribute("user",user);

        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);

        /*获取所有的用户*/
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin";
    }
}
