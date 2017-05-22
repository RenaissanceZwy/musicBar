package com.music.web.controller;

import com.music.web.bean.UserBasedRecommendate;
import com.music.web.constant.JsonResult;
import com.music.web.entity.Music;
import com.music.web.entity.PlayNum;
import com.music.web.service.MusicService;
import com.music.web.util.FileUtil;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推荐相关接口
 * Created by Administrator on 2017/5/20.
 */
@RequestMapping(value = "recom")
@Controller
public class RecomController {

    private static  final Logger logger  = LoggerFactory.getLogger(RecomController.class);

    @Autowired
    private MusicService musicService;
    /**
     * 获取用户的推荐列表
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list")
    public Object getUserRecomList(HttpServletRequest request , HttpServletResponse response) throws Exception{
        List<Music> musics = new ArrayList<Music>();
        List<RecommendedItem> items = UserBasedRecommendate.getRecommendateItemsByUid(1l);
        for(RecommendedItem item:items){
            musics.add(musicService.selectMusicBySongId(item.getItemID()+""));
        }

        return new JsonResult("200","获取用户推荐列表成功",musics);
    }

    /**
     * 数据预处理生出数据文件
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "preprc")
    public Object preProcessDataAndGenerateFile(HttpServletRequest request ,
                                                HttpServletResponse response) throws Exception{

        //获取所有的用户的音乐的播放次数
        List<PlayNum> playNumList = musicService.selectMusicPlayNum();
        //进行评分
        String scores = "";
        Map<Integer,Integer> uids = new HashMap<Integer, Integer>();
        for(PlayNum item:playNumList){
            //获取此用户听歌总数
            int length = 0;
            if(uids.get(item.getUid()) == null){
                length = musicService.selectTotalPlayNumByUid(item.getUid());
                uids.put(item.getUid(),length);
            }else{
                length = uids.get(item.getUid());
            }
            int i = item.getNum();
            int score =(i/length)<0.2?5:((i/length)<0.4?4:((i/length)<0.6?3:((i/length)<0.8?2:1)));
            //将数据插入到文件中
            scores += item.getUid()+","+item.getMid()+","+score+"\n";
        }


        //将数据存储在文件中
        String fileName = "G:/project/music-web/app/src/data/pre.data";
        File file = new File(fileName);
        FileUtil.writeDataToFile(scores,file);

        return new JsonResult("200","数据处理成功","");
    }


}
