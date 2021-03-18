package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CompevaluationBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 综合测评
 */
public interface CompevaluationDao {
    @Select("select * from compevaluation;")
    @Results(
        {
            @Result(column = "collect_id", property = "collectID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "vid", property = "vID")
        }
    )
    public List<CompevaluationBean> selectAll();
}
