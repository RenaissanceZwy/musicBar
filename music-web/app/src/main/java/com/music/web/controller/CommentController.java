package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.entity.Comment;
import com.music.web.entity.User;
import com.music.web.service.CommentService;
import com.music.web.vo.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 评论相关接口
 * Created by Administrator on 2017/5/2.
 */
@RequestMapping(value = "comment")
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*进行评论操做*/
    @ResponseBody
    @RequestMapping(value = "/add" ,method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult addComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        comment.setTime(new Date());
        comment.setUid(user.getId());

        if(!commentService.insertComment(comment)){
            return new JsonResult(JsonResultCode.FAILURE,"评论失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"评论成功","");
    }

    /*进行删除评论操做*/
    @ResponseBody
    @RequestMapping(value = "/del" ,method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult deleteComment(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        String id = request.getParameter("id");
        if(!commentService.deleteComment(Long.valueOf(id))){
            return new JsonResult(JsonResultCode.FAILURE,"删除失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"删除成功","");
    }

    /*进行点赞评论操做*/
    @ResponseBody
    @RequestMapping(value = "/like" ,method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult likeComment(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        String id = request.getParameter("cid");
        CommentInfo comment = commentService.getCommentById(Long.valueOf(id));
        if(null == comment){
            return new JsonResult(JsonResultCode.FAILURE,"该评论已经删除","");
        }
        boolean result = commentService.modifyCommentLike(Long.valueOf(id),comment.getLikeNum()+1);
        if(!result){
            return new JsonResult(JsonResultCode.FAILURE,"点赞失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"点赞成功","");
    }

    /**
     * 获取评论信息
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info" ,method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult getComments(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return new JsonResult(JsonResultCode.FAILURE,"参数获取失败","");
        }
        List<CommentInfo> commentInfo = commentService.getComment(id,0);
        return new JsonResult(JsonResultCode.SUCCESS,"评论信息获取成功",commentInfo);
    }
}
