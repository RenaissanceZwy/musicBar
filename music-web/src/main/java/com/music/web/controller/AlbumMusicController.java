package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.service.AlbumMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/29.
 */
@RequestMapping(value = "albumMusic")
@Controller
public class AlbumMusicController {

    @Autowired
    private AlbumMusicService albumMusicService;

    @RequestMapping(value = "test")
    @ResponseBody
    public JsonResult test(HttpServletRequest request, Model model){
        return  null;
    }
}
