package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EnrollPlanHistoryBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年招生计划
 */
public interface EnrollPlanHistoryDao {
    @Select("select * from enroll_plan_history;")
    @Results(
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "years", property = "years"),
            @Result(column = "batch_no", property = "batchNo"),
            @Result(column = "plan_category", property = "planCategory"),
            @Result(column = "family", property = "family"),
            @Result(column = "plan_num", property = "planNum"),
            @Result(column = "tuitionfee", property = "tuitionfee"),
            @Result(column = "school_system", property = "schoolSystem"),
            @Result(column = "memo", property = "memo")
        }
    )
    public List<EnrollPlanHistoryBean> selectAll();
}
