package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.entity.Album;
import com.music.web.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 歌单相关
 * Created by Administrator on 2017/5/1.
 */
@RequestMapping(value = "album")
@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 新建一个歌单
     * @param request
     * @param model
     * @param album
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult insert(HttpServletRequest request, Model model, Album album){
        if(null == album){
            return new JsonResult("201","参数获取失败","");
        }
        if(StringUtils.isEmpty(album.getName())){
            return new JsonResult("201","歌单的名字不能为空","");
        }
        album.setCreatetime(new Date());
        if(!albumService.insertAlbum(album)){
            return new JsonResult("201","新建歌单失败","");
        }
        return new JsonResult("200","新建歌单成功","");
    }


    /**
     * 删除一个歌单
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public JsonResult delete(HttpServletRequest request,Model model){
        if(StringUtils.isEmpty(request.getParameter("id"))){
            return new JsonResult("201","id获取失败","");
        }
        if(!albumService.deleteAlbum(Integer.valueOf(request.getParameter("id")))){
            return new JsonResult("201","删除歌单失败","");
        }

        return new JsonResult("200","删除歌单成功","");
    }

    /**
     * 获取一个歌单的信息
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get")
    public JsonResult get(HttpServletRequest request,Model model){
        if(StringUtils.isEmpty(request.getParameter("id"))){
            return new JsonResult("201","id获取失败","");
        }
        Album album = albumService.selectAlbumInfo(Integer.valueOf(request.getParameter("id")));
        return new JsonResult("200","歌单信息获取成功",album);
    }

    /**
     * 判断歌单是否存在
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "exist")
    public JsonResult exist(HttpServletRequest request,Model model){
        if(StringUtils.isEmpty(request.getParameter("name"))){
            return new JsonResult("201","名字获取失败","");
        }
        Album album = albumService.selectAlbumInfo(request.getParameter("name"));
        return new JsonResult("200","歌单信息获取成功",album);
    }


    /**
     * 获取一个专辑的信息
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "info")
    public JsonResult albumInfo(HttpServletRequest request,Model model){
        return new JsonResult("200","歌单信息获取成功","");
    }
}
