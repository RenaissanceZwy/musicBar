package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.entity.Music;
import com.music.web.entity.User;
import com.music.web.service.MusicService;
import com.music.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhaowenyi on 2016/11/15.
 */
@RequestMapping(value={"index",""})
@Controller
public class IndexController {

    private static  final Logger logger  = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MusicService musicService;

    /*主页显示*/
   @RequestMapping(value = "")
    public String test(HttpServletRequest request, Model model, HttpServletResponse response){
       /*获取播放排行榜*/
       List<Music> playRank = musicService.selectMusicOrderByPlayNum(4);
       model.addAttribute("playRank",playRank);
       /*获取收藏排行榜*/
       List<Music> collectRank = musicService.selectMusicOrderByCollect(4);
       model.addAttribute("collectRank",collectRank);
       /*获取新歌排行榜*/

       return "index";
    }


   /* 进行登录操作*/
    @ResponseBody
    @RequestMapping(value = "/signIn",method = {RequestMethod.GET, RequestMethod.POST})
    public Object signIn(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断该用户是否存在
        int exist = userService.getCountOfName(username);
        if (exist == 0){
            return  new JsonResult(JsonResultCode.FAILURE,"该用户不存在","");
        }

        //判断是否存在该用户
        User user = userService.getUserByUser(username,password);
        if (user == null){
            return  new JsonResult(JsonResultCode.FAILURE,"密码不正确","");
        }
        if (user.getStatus() == 0){
            return  new JsonResult(JsonResultCode.FAILURE,"对不起该用户已被禁用","");
        }
        request.getSession().setAttribute(CommonConstants.CURRENT_USER,user);
        logger.info("session="+request.getSession().getId());
        return  new JsonResult(JsonResultCode.SUCCESS,"登录成功",user);
    }

    /*进行注册操作*/
    @ResponseBody
    @RequestMapping(value = "/signUp",method ={RequestMethod.GET, RequestMethod.POST} )
    public Object signUp(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断该用户是否存在
        int exist = userService.getCountOfName(username);
        if (exist > 0){
            return  new JsonResult(JsonResultCode.FAILURE,"该用户名已经存在","");
        }

        User user = new User(username,password,"","","0",0,0);
        boolean result = userService.insertUser(user);
        if(!result){
            return  new JsonResult(JsonResultCode.FAILURE,"用户注册失败","");
        }

        return  new JsonResult(JsonResultCode.SUCCESS,"注册成功","");
    }

    /*进行登出操作*/
    @RequestMapping(value = "/signOut",method ={RequestMethod.GET, RequestMethod.POST} )
    public String signOut(HttpServletRequest request, Model model){

        request.getSession().setAttribute(CommonConstants.CURRENT_USER,null);

        return "index";
    }

    /*进行登出操作*/
    @ResponseBody
    @RequestMapping(value = "/sign/out",method ={RequestMethod.GET, RequestMethod.POST} )
    public JsonResult signOutJson(HttpServletRequest request, Model model){

        request.getSession().setAttribute(CommonConstants.CURRENT_USER,null);

        return  new JsonResult(JsonResultCode.SUCCESS,"登出成功","");
    }
}
