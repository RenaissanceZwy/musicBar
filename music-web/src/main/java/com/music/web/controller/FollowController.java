package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.entity.Follow;
import com.music.web.entity.User;
import com.music.web.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/1.
 */
@RequestMapping(value = "follow")
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 进行关注操作
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult follow(HttpServletRequest request, Model model){
        //获取用户id
        String uid1 = request.getParameter("uid");
        if(StringUtils.isEmpty(uid1)){
            return new JsonResult("201","参数获取失败","");
        }
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(null == user){
            return new JsonResult("201","请先进行登录","");
        }
        Follow follow = new Follow();
        follow.setUid1(Integer.valueOf(uid1));
        follow.setUid2(user.getId());
        if(null != followService.selectFollow(follow)){
            return new JsonResult("201","已经关注了该用户","");
        }
        if(!followService.insertFollow(follow)){
            return new JsonResult("201","关注失败","");
        }

        return new JsonResult("200","关注成功","");
    }


    /**
     * 取消关注
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "cancel")
    public JsonResult cancelFollow(HttpServletRequest request,Model model){
        //获取用户id
        String uid1 = request.getParameter("uid");
        if(StringUtils.isEmpty(uid1)){
            return new JsonResult("201","参数获取失败","");
        }
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(null == user){
            return new JsonResult("201","请先进行登录","");
        }
        Follow follow = new Follow();
        follow.setUid1(Integer.valueOf(uid1));
        follow.setUid2(user.getId());
        if(!followService.cancelFollow(follow)){
            return new JsonResult("201","取消关注失败","");
        }

        return new JsonResult("200","取消关注成功","");
    }

    /**
     * 获取记录
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "record")
    public JsonResult selectFollow(HttpServletRequest request,Model model,Follow follow){
        Follow exist = followService.selectFollow(follow);
        return new JsonResult("200","获取关注记录成功",exist);
    }
}
