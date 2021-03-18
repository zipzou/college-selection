package com.github.xiaotong.collegeselection.dao.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.MajorBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

/**
 * 招生专业
 */
public interface MajorDao {
    @Select("select * from major;")
    @Results(
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "levels", property = "levels"),
            @Result(column = "school_system", property = "schoolSystem"),
            @Result(column = "tuitionfee", property = "tuitionfee"),
            @Result(column = "ranking", property = "ranking"),
            @Result(column = "requirements", property = "requirements"),
            @Result(column = "jobs_type", property = "jobsType")
        }
    )
    public List<MajorBean> selectAll();
}
