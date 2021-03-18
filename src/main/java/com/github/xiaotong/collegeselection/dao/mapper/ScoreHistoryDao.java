package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ScoreHistoryBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年各省分数线
 */
public interface ScoreHistoryDao {
    @Select("SELECT p.province_no,province_name,years,batch_no,comprehensive,arts,science from province_info as p,score_history as s where p.province_no = s.province_no;")
    @Results( id = "scoreHistory",value = 
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "province_name", property = "provinceName"),
            @Result(column = "years", property = "years"),
            @Result(column = "batch_no", property = "batchNo"),
            @Result(column = "comprehensive", property = "comprehensive"),
            @Result(column = "arts", property = "arts"),
            @Result(column = "science", property = "science")
        }
    )
    public List<ScoreHistoryBean> selectAll();

    //根据省份no查找该省份的分数线
    @Select("SELECT p.province_no,province_name,years,batch_no,comprehensive,arts,science from province_info as p,score_history as s where p.province_no = s.province_no and p.province_no = #{pNo};")
    @ResultMap(value = "scoreHistory")
    public List<ScoreHistoryBean> getInfoByNo(@Param("pNo")String pNo);
}
