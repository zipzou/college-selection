package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.SpecialRequirementsBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 专业特殊要求
 */
public interface SpecialRequirementsDao {
    @Select("select * from special_requirements;")
    @Results(
        {
            @Result(column = "sr_year", property = "srYear"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "requirement", property = "requirement")
        }
    )
    public List<SpecialRequirementsBean> selectAll();
}
