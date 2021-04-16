package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollInfoBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年录取情况视图
 */
public interface ViewEnrollInfoDao {
    @Select("select * from view_enroll_info;")
    @Results(id = "enrollInfo",value = 
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "province_name", property = "provinceName"),
            @Result(column = "years", property = "years"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "university_name", property = "universityName"),
            @Result(column = "plan_category", property = "planCategory"),
            @Result(column = "numbers", property = "numbers"),
            @Result(column = "min_score", property = "minScore"),
            @Result(column = "avg_score", property = "avgScore"),
            @Result(column = "avg_ranking", property = "avgRanking"),
            @Result(column = "min_ranking", property = "minRanking")
        }
    )
    public List<ViewEnrollInfoBean> selectAll();

    //查这个省份各个学校的录取信息
    @Select("select * from view_enroll_info where province_no = #{pNo};")
    @ResultMap(value = "enrollInfo")
    public List<ViewEnrollInfoBean> getAnProvince(@Param("pNo") String pNo);

    //查这个学校在各个省份的录取信息
    @Select("select * from view_enroll_info where university_id = #{id};")
    @ResultMap(value = "enrollInfo")
    public List<ViewEnrollInfoBean> getAnUniversity(@Param("id") Integer id);

    //查这个学校在这个省份的录取信息
    @Select("select * from view_enroll_info where university_id = #{id} and province_no = #{pNo};")
    @ResultMap(value = "enrollInfo")
    public List<ViewEnrollInfoBean> getAnEnrollInfo(@Param("id") Integer id,@Param("pNo") String pNo);
}
