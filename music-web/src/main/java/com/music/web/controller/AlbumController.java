package com.music.web.controller;

import com.music.web.constant.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/1.
 */
@RequestMapping(value = "album")
@Controller
public class AlbumController {

    @ResponseBody
    @RequestMapping(value = "test")
    public JsonResult test(HttpServletRequest request, Model model){
        return  null;
    }
}
