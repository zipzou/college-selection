package com.github.xiaotong.collegeselection.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.MockAspirationBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

/**
 * 模拟志愿
 */
public interface MockAspirationDao {
    @Select("select * from mock_aspiration;")
    @Results(
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "stu_no", property = "stuNo"),
            @Result(column = "exam_time", property = "examTime"),
            @Result(column = "first_rate", property = "firstRate"),
            @Result(column = "second_rate", property = "secondRate"),
            @Result(column = "special_rate", property = "specialRate")
        }
    )
    public List<MockAspirationBean> selectAll();
}
