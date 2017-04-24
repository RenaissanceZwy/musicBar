package com.music.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.entity.CollectionMusic;
import com.music.web.entity.Comment;
import com.music.web.entity.Music;
import com.music.web.entity.User;
import com.music.web.service.CollectionService;
import com.music.web.service.CommentService;
import com.music.web.service.MusicService;
import com.music.web.util.PureNetUtil;
import com.music.web.vo.CommentInfo;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
@Controller
@RequestMapping(value ="/music")
public class MusicController {

    private static  final Logger logger = LoggerFactory.getLogger(MusicController.class);

    @Autowired
    private MusicService musicService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CollectionService collectionService;

    /*我的音乐界面*/
    @RequestMapping(value = "/myMusic" ,method = {RequestMethod.GET, RequestMethod.POST})
    public String myMusic(HttpServletRequest request, Model model, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);

       /* 如果用户已经登录*/
        if(user!= null){
           /*获取用户的评论*/
            List<CommentInfo> commentInfos = commentService.getCommentByUid(user.getId());
            model.addAttribute("commentInfos",commentInfos);

        /*获取用户的最近播放*/
            List<Music> recentPlay = collectionService.selectMusicByUser(user.getId(),CommonConstants.RECENT_PLAY);
            model.addAttribute("recentPlay",recentPlay);

        /*获取用户的收藏*/
            List<Music> collectionMusic = collectionService.selectMusicByUser(user.getId(),CommonConstants.COLLECTION);
            model.addAttribute("collectionMusic",collectionMusic);

        /*获取用户的最爱*/
            List<Music> favorite = collectionService.selectMusicByUser(user.getId(),CommonConstants.MY_FAVORITE);
            model.addAttribute("favorite",favorite);
        }

        return "myMusic";
    }

    /*进行收藏操做*/
    @ResponseBody
    @RequestMapping(value = "/collect" ,method = {RequestMethod.GET, RequestMethod.POST})
    public Object CollectMusic(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }

        String songId = request.getParameter("songId");
        String type = request.getParameter("type");

        CollectionMusic collectionMusic = new CollectionMusic(
                user.getId(),Long.valueOf(songId),new Date(),Integer.valueOf(type));
        boolean result = collectionService.insertCollection(collectionMusic);
        if(!result){
            return new JsonResult(JsonResultCode.FAILURE,"收藏失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"收藏成功","");
    }

    /*进行取消收藏操做*/
    @ResponseBody
    @RequestMapping(value = "/cancel" ,method = {RequestMethod.GET, RequestMethod.POST})
    public Object CancelCollect(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);

        String mid = request.getParameter("mid");
        boolean result = collectionService.deleteCollection(Long.valueOf(mid),user.getId(),CommonConstants.COLLECTION);
        if(!result){
            new JsonResult(JsonResultCode.FAILURE,"取消收藏失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"取消收藏成功","");
    }


   /* 某首歌的界面*/
    @RequestMapping(value = "/play" ,method = {RequestMethod.GET, RequestMethod.POST})
    public String song(HttpServletRequest request,Model model, HttpServletResponse response){
        /*用户的信息*/
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        /*获取歌曲id*/
        String songId = request.getParameter("id");
        /*判断是否存在已经存储该歌曲信息*/
        Music music = null;
        music = musicService.selectMusicBySongId(songId);
        if(music == null){
            /* 获取歌曲的信息*/
            String url = CommonConstants.SONG_INFO_URL+"?id="+songId+"&ids=%5B"+songId+"%5D";
            String result = PureNetUtil.get(url);
            JSONObject obj = JSONObject.parseObject(result);

           /* 封装vo*/
            JSONArray array =obj.getJSONArray("songs");
            JSONObject songObj = array.getJSONObject(0);
            //获取专辑封面
            String picUrl = songObj.getJSONObject("album").getString("picUrl");
            //获取歌手名称
            String singer = songObj.getJSONObject("album").getJSONArray("artists").getJSONObject(0).getString("name");
            //获取专辑名称
            String albumName = songObj.getJSONObject("album").getString("name");
            //获取歌曲名称
            String songName = songObj.getString("name");

            music = new Music(songName,singer,albumName,songId.toString(),picUrl,1);
            musicService.insertMusic(music);
        }else{
            musicService.updateMusicPlayNum(music.getPlayNum()+1,songId);
        }
        model.addAttribute("music",music);


        /*获取评论信息*/
        List<CommentInfo> commentInfo = commentService.getCommentBySongId(songId);
        model.addAttribute("commentInfo",commentInfo);

       /* 如果用户已经登录*/
        if(user != null){
             /*判断用户是否已经收藏*/
            boolean collected = collectionService.checkCollectionExist(Long.valueOf(songId),user.getId(),CommonConstants.COLLECTION);
            model.addAttribute("collected",collected);

             /*加入用户最近播放队列*/
            boolean recntPlay = collectionService.checkCollectionExist(Long.valueOf(songId),user.getId(),CommonConstants.RECENT_PLAY);
            if(recntPlay){
                collectionService.deleteCollection(Long.valueOf(songId),user.getId(),CommonConstants.RECENT_PLAY);
            }

            CollectionMusic collectionMusic = new CollectionMusic(user.getId(),Long.valueOf(songId),new Date(),CommonConstants.RECENT_PLAY);
            collectionService.insertCollection(collectionMusic);
        }

        return "play";
    }

    /*进行评论操做*/
    @ResponseBody
    @RequestMapping(value = "/comment" ,method = {RequestMethod.GET, RequestMethod.POST})
    public Object publishComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        comment.setTime(new Date());
        comment.setUid(user.getId());

        boolean result = commentService.insertComment(comment);
        if(!result){
            return new JsonResult(JsonResultCode.FAILURE,"评论失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"评论成功","");
    }

    /*进行删除评论操做*/
    @ResponseBody
    @RequestMapping(value = "/deleteComment" ,method = {RequestMethod.GET, RequestMethod.POST})
    public Object deleteComment(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        String id = request.getParameter("cid");
        boolean result = commentService.deleteComment(Long.valueOf(id));
        if(!result){
            new JsonResult(JsonResultCode.FAILURE,"删除失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"删除成功","");
    }

    /*进行点赞评论操做*/
    @ResponseBody
    @RequestMapping(value = "/likeComment" ,method = {RequestMethod.GET, RequestMethod.POST})
    public Object likeComment(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        if(user == null){
            return new JsonResult(JsonResultCode.FAILURE,"请先进行登录","");
        }
        String id = request.getParameter("cid");
        CommentInfo comment = commentService.getCommentById(Long.valueOf(id));
        boolean result = commentService.modifyCommentLike(Long.valueOf(id),comment.getLikeNum()+1);
        if(!result){
            new JsonResult(JsonResultCode.FAILURE,"点赞失败","");
        }

        return new JsonResult(JsonResultCode.SUCCESS,"点赞成功","");
    }



}
