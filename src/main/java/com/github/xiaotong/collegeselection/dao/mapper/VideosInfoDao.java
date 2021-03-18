package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.VideoListBean;
import com.github.xiaotong.collegeselection.dao.bean.VideosInfoBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 视频库
 */
public interface VideosInfoDao {
    @Select("select * from videos_info;")
    @Results(id = "video",value = 
        {
            @Result(column = "video_id", property = "videoID"),
            @Result(column = "video_title", property = "videoTitle"),
            @Result(column = "video_label", property = "videoLabel"),
            @Result(column = "video_filepath", property = "videoFilepath"),
            @Result(column = "video_url", property = "videoUrl")
        }
    )
    public List<VideosInfoBean> selectAll();

    /**
     * 得到视频列表
     * @return
     */
    @Select("select video_id,video_title,video_label from videos_info;")
    @Results(id = "videolist",value = 
        {
            @Result(column = "video_id", property = "videoID"),
            @Result(column = "video_title", property = "videoTitle"),
            @Result(column = "video_label", property = "videoLabel")
        }
    )
    public List<VideoListBean> getVideoList();

    
    /**
     * 根据标签得到视频列表
     * @param videoLabel
     * @return
     */
    @Select("select video_id,video_title,video_label from videos_info where video_label = #{videoLabel};")
    @ResultMap(value = "videolist")
    public List<VideoListBean> getVideoByLabel(@Param("videoLabel")String videoLabel);
    
    /**
     * 根据id得到一个视频
     * @param videoID
     * @return
     */
    @Select("select * from videos_info where video_id = #{videoID};")
    @ResultMap(value = "video")
    public VideosInfoBean getAnVideo(@Param("videoID")Integer videoID);
}
