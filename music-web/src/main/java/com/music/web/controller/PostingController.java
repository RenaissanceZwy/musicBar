package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.entity.Posting;
import com.music.web.entity.User;
import com.music.web.service.PostingService;
import com.music.web.vo.PostingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 帖子相关接口
 * Created by Administrator on 2017/5/1.
 */
@Controller
@RequestMapping(value = "posting")
public class PostingController {

    @Autowired
    private PostingService postingService;

    /**
     * 新建一个帖子
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult add(HttpServletRequest request, Model model, Posting posting){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(null == user){
            return new JsonResult("201","请先进行登录","");
        }
        if(posting == null){
            return new JsonResult("201","获取参数失败","");
        }
        posting.setCreatetime(new Date());
        posting.setUid(user.getId());
        if(!postingService.insertPosting(posting)){
            return new JsonResult("201","新建帖子失败","");
        }
        return new JsonResult("200","新建帖子成功","");
    }

    /**
     * 删除帖子
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public JsonResult delete(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(null == user){
            return new JsonResult("201","请先进行登录","");
        }
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return new JsonResult("201","参数获取失败","");
        }
        if(!postingService.deletePosting(Integer.valueOf(id))){
            return new JsonResult("201","删除帖子失败","");
        }

        return new JsonResult("200","删除帖子成功","");
    }

    /**
     * 获取帖子信息
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "info")
    public JsonResult info(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return new JsonResult("201","参数获取失败","");
        }
        PostingVo vo = postingService.selectPosting(Integer.valueOf(id));
        return new JsonResult("200","获取帖子成功",vo);
    }

}
