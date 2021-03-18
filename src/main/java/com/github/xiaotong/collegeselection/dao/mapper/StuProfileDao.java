package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.StuProfileBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 考生偏好
 */
public interface StuProfileDao {
    @Select("select * from stu_profile;")
    @Results(
        {
            @Result(column = "report_id", property = "reportID"),
            @Result(column = "stu_no", property = "stuNo"),
            @Result(column = "holland_test_time", property = "hollandTestTime"),
            @Result(column = "holland_score", property = "hollandScore"),
            @Result(column = "mbti_test_time", property = "mbtiTestTime"),
            @Result(column = "mbti_score", property = "mbtiScore")
        }
    )
    public List<StuProfileBean> selectAll();
}
