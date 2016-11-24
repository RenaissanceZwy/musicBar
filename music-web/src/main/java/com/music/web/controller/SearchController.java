package com.music.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.constant.PureNetUtil;
import com.music.web.entity.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @ResponseBody
    @RequestMapping(value = "/test",method = {RequestMethod.GET, RequestMethod.POST})
    public Object search(HttpServletRequest request, HttpServletResponse response){
        //获取搜索关键词
        String keyWord = request.getParameter("keyWord");
        String url = CommonConstants.SONG_SEARCH+"?type=1&filterDj=true&s="+keyWord+"&limit=10&offset=0";
        String result = PureNetUtil.get(url);
        JSONObject obj = JSONObject.parseObject(result);


        return new JsonResult(JsonResultCode.SUCCESS,"获取信息成功",obj);
    }

    @RequestMapping(value = "/song",method = {RequestMethod.GET, RequestMethod.POST})
    public String getSongById(HttpServletRequest request, HttpServletResponse response, Model model){
        //获取搜索关键词
        String keyWord = request.getParameter("keyWord");
        String url = CommonConstants.SONG_SEARCH+"?type=1&filterDj=true&s="+keyWord+"&limit=10&offset=0";
        String result = PureNetUtil.get(url);
        JSONObject obj = JSONObject.parseObject(result);

        //获取歌曲
        List<Music> musicList = new LinkedList<Music>();
        if(obj == null){
            model.addAttribute("result",0);
        }else {
            JSONObject object = obj.getJSONObject("result");
            if (object == null) {
                model.addAttribute("result", 0);
            } else {

                JSONArray array = object.getJSONArray("songs");
                for (int i = 0; i < array.size(); i++) {
            /*歌曲id*/
                    String songId = array.getJSONObject(i).getString("id");
            /*歌曲名称*/
                    String musicName = array.getJSONObject(i).getString("name");
            /*获取歌手名称*/
                    String singer = array.getJSONObject(i).getJSONArray("artists").getJSONObject(0).getString("name");
           /* 获取专辑图片*/
                    String picUrl = array.getJSONObject(i).getJSONObject("album").getString("picUrl");
              /*获取专辑名称*/
                    String albumName = array.getJSONObject(i).getJSONObject("album").getString("name");

                    Music music = new Music(musicName, singer, albumName, songId, picUrl, 0);
                    musicList.add(music);
                }

                model.addAttribute("result", 1);
                model.addAttribute("musicList", musicList);
            }
        }
        return "resultList";
    }
}
