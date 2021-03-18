package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EnrollInfoBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年录取情况
 */
public interface EnrollInfoDao {
    @Select("select * from enroll_info;")
    @Results(
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "years", property = "years"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "plan_category", property = "planCategory"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "numbers", property = "numbers"),
            @Result(column = "max_score", property = "maxScore"),
            @Result(column = "min_score", property = "minScore"),
            @Result(column = "avg_score", property = "avgScore"),
            @Result(column = "max_ranking", property = "maxRanking"),
            @Result(column = "min_ranking", property = "minRanking")
        }
    )
    public List<EnrollInfoBean> selectAll();
}
