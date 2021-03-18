package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.AspirationBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 高考志愿
 */
public interface AspirationDao {
    /**
     * 
     * @return
     * 
     */
    @Select("select * from aspiration;")
    @Results(
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "stu_no", property = "stuNo"),
            @Result(column = "admission_rate", property = "admissionRate")
        }
    )
    public List<AspirationBean> selectAll();
}
