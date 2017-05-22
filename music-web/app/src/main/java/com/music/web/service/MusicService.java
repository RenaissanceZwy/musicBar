package com.music.web.service;

import com.music.web.entity.Music;
import com.music.web.entity.PlayNum;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface MusicService {
    /*通过歌曲id获取歌曲*/
    public Music selectMusicBySongId( String songId);

    /*插入歌曲*/
    public boolean insertMusic ( Music music);

    /*修改歌曲播放次数*/
    public boolean updateMusicPlayNum(int playNum, String songId);

    /*获取播放排行榜*/
    public List<Music> selectMusicOrderByPlayNum( int total);

    /*获取收藏排行榜*/
    public List<Music> selectMusicOrderByCollect( int total);

    //更新某首歌的播放次数
    public  boolean updateMusicPlayNum(PlayNum playNum);

    //获取所有的播放次数
    public List<PlayNum> selectMusicPlayNum();

    //获取某个用户的听歌总次数
    public int selectTotalPlayNumByUid(int uid);

}
