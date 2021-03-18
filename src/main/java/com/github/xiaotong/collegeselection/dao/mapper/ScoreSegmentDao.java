package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ScoreSegmentBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 一分一段
 */
public interface ScoreSegmentDao {
    @Select("SELECT p.province_no,province_name,years,stu_category,score,numbers,ranks from province_info as p,score_segment as s where p.province_no = s.province_no;")
    @Results( id = "scoreseg",value = 
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "province_name", property = "provinceName"),
            @Result(column = "years", property = "years"),
            @Result(column = "stu_category", property = "stuCategory"),
            @Result(column = "score", property = "score"),
            @Result(column = "numbers", property = "numbers"),
            @Result(column = "ranks", property = "ranks")
        }
    )
    public List<ScoreSegmentBean> selectAll();

    /**
     * 根据省份no查看
     */
    @Select("SELECT p.province_no,province_name,years,stu_category,score,numbers,ranks from province_info as p,score_segment as s where p.province_no = s.province_no and p.province_no = #{pNo};")
    @ResultMap(value = "scoreseg")
    public List<ScoreSegmentBean> getAnProvinceSeg(@Param("pNo") String pNo);
}
