package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CollectionVideoBean;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 视频收藏
 */
public interface CollectVideoDao {
    @Select("select c.video_id,video_title,user_no from collection_video as c,videos_info as v where user_no = #{userNo} and v.video_id = c.video_id;")
    @Results(id = "videoCollection",value = 
        {
            @Result(column = "video_id", property = "videoID"),
            @Result(column = "video_title", property = "videoTitle"),
            @Result(column = "user_no", property = "userNo")
        }
    )
    public List<CollectionVideoBean> getVideoCollection(@Param("userNo") Long userNo);

    /**
     * 获取单个收藏
     */
    @Select("select * from collection_video where user_no = #{userNo} and video_id = #{videoID};")
    @ResultMap(value = "videoCollection")
    public CollectionVideoBean getAnVideoCollection(@Param("userNo") Long userNo,@Param("videoID") Integer videoID);
    
    /**
     * 插入个人视频收藏
     */
    @Insert("INSERT into collection_video(video_id,user_no) VALUES(#{videoID},#{userNo});")
    public void insertVideoCollect(@Param("videoID") Integer videoID,@Param("userNo") Long userNo);
    
    /**
     * 取消个人视频收藏
     * @param videoID
     * @param userNo
     */
    @Delete("delete from collection_video where video_id = #{videoID} and user_no = #{userNo};")
    public void deleteVideoCollect(@Param("videoID") Integer videoID,@Param("userNo") Long userNo);
}
