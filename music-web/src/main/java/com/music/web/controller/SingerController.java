package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.entity.Singer;
import com.music.web.service.SingerService;
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
@RequestMapping(value = "singer")
@Controller
public class SingerController {

    @Autowired
    private SingerService singerService;

    /**
     * 新建歌手
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult add(HttpServletRequest request, Model model, Singer singer){
        if(StringUtils.isEmpty(singer.getName())){
            return new JsonResult("201","歌手名称不能为空","");
        }
        if(!singerService.insertSinger(singer)){
            return new JsonResult("201","新建歌手失败","");
        }
        return new JsonResult("200","新建歌手成功","");
    }

    /**
     * 进行删除歌手
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public JsonResult delete(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return new JsonResult("201","参数获取失败","");
        }
        if(!singerService.deleteSinger(Integer.valueOf(id))){
            return new JsonResult("201","删除歌手失败","");
        }
        return new JsonResult("200","删除歌手成功","");
    }

    /**
     * 获取歌手信息
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
        Singer singer = singerService.selectSinger(Integer.valueOf(id));
        return new JsonResult("200","获取歌手成功",singer);
    }
}
