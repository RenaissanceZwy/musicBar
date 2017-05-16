package com.music.web.controller;

import com.music.web.entity.Album;
import com.music.web.entity.Label;
import com.music.web.entity.User;
import com.music.web.service.*;
import com.music.web.vo.CommentInfo;
import com.music.web.vo.PostingVo;
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

    @Autowired
    private PostingService postingService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private AlbumService albumService;

    /**
     * 主页显示
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String test(HttpServletRequest request,Model model, HttpServletResponse response ){
        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);

        /*获取所有的用户*/
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin";
    }


    /**
     * 用户管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/user")
    public String adminUser(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的用户*/
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        model.addAttribute("page_type","100");

        return "admin/user";
    }

    /**
     * 评论管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/comment")
    public String adminComment(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);
        model.addAttribute("page_type","200");


        return "admin/comment";
    }


    /**
     * 帖子管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/post")
    public String adminPost(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<PostingVo> postings = postingService.selectPostings();
        model.addAttribute("postings",postings);
        model.addAttribute("page_type","300");


        return "admin/post";
    }

    /**
     * 音乐管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/music")
    public String adminMusic(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);
        model.addAttribute("page_type","400");


        return "admin/music";
    }

    /**
     *专辑管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/album")
    public String adminAlbum(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<Album> albums= albumService.selectAllAlbums();
        model.addAttribute("albums",albums);
        model.addAttribute("page_type","500");


        return "admin/album";
    }


    /**
     * 标签管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/label")
    public String adminLabel(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<Label> labels = labelService.selectLabels();
        model.addAttribute("labels",labels);
        model.addAttribute("page_type","600");


        return "admin/label";
    }


    @RequestMapping(value = "/test")
    public String test2(HttpServletRequest request,Model model,HttpServletResponse response,
                        @RequestParam(required = true ,value = "toId") Integer toId){

        //获取当前对话的用户
        User toUser = userService.getUserById(toId.toString());

        model.addAttribute("toUser",toUser);

        return "room";
    }

}
