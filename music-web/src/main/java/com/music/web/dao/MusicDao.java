package com.music.web.dao;

import com.music.web.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Repository
public interface MusicDao {

    /*通过歌曲id获取歌曲*/
    public Music selectMusicBySongId(@Param("songId") String songId);

    /*插入歌曲*/
    public int insertMusic (@Param("music") Music music);

    /*修改歌曲播放次数*/
    public int updateMusicPlayNum(@Param("playNum") int playNum, @Param("songId") String songId);

    /*获取播放排行榜*/
    public List<Music> selectMusicOrderByPlayNum(@Param("total") int total);

    /*获取收藏排行榜*/
    public List<Music> selectMusicOrderByCollect(@Param("total") int total);



}
