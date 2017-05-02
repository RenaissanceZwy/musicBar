package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.entity.AlbumMusic;
import com.music.web.entity.Music;
import com.music.web.service.AlbumMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
@RequestMapping(value = "albumMusic")
@Controller
public class AlbumMusicController {

    @Autowired
    private AlbumMusicService albumMusicService;

    /**
     * 将歌曲插到歌单中
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JsonResult add(HttpServletRequest request, Model model){
        String mid = request.getParameter("mid");
        if(StringUtils.isEmpty(mid)){
            return new JsonResult("201","参数获取失败","");
        }
        String aid = request.getParameter("aid");
        if(StringUtils.isEmpty(aid)){
            return new JsonResult("201","参数获取失败","");
        }
        if(!albumMusicService.insertAlbumMusic(Integer.valueOf(aid),mid)){
            return new JsonResult("201","操作失败","");
        }
        return new JsonResult("200","操作成功","");
    }

    /**
     * 进行删除操作
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public JsonResult delete(HttpServletRequest request,Model model){
        String ids = request.getParameter("ids");
        if(StringUtils.isEmpty(ids)){
            return new JsonResult("201","参数获取失败","");
        }
        if(!albumMusicService.deleteMusicFromAlbum(ids)){
            return new JsonResult("201","操作失败","");
        }
        return new JsonResult("200","操作成功","");
    }


    /**
     * 获取歌单的所有音乐信息
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "get")
    @ResponseBody
    public JsonResult info(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return new JsonResult("201","参数获取失败","");
        }
        List<Music> musics = albumMusicService.selectAlbumMusic(Integer.valueOf(id));
        return new JsonResult("200","获取音乐成功",musics);
    }

    /**
     * 判断某首歌是否在歌单中
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "exist")
    @ResponseBody
    public JsonResult exist(HttpServletRequest request, Model model, AlbumMusic albumMusic){
        if(StringUtils.isEmpty(albumMusic.getAid())){
            return new JsonResult("201","参数获取失败","");
        }
        if(StringUtils.isEmpty(albumMusic.getMid())){
            return new JsonResult("201","参数获取失败","");
        }
        AlbumMusic exist = albumMusicService.selectAlbumMusic(albumMusic.getAid(),albumMusic.getMid());
        return new JsonResult("200","获取记录成功",exist);
    }
}
