package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ViewBasicMajorBean;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 强基计划专业视图
 */
public interface ViewBasicMajorDao {
    @Select("select * from view_basic_major_plan where id = #{universityID};")
    @Results(
        {
            @Result(column = "id", property = "id"),
            @Result(column = "u_code", property = "uCode"),
            @Result(column = "m_code", property = "mCode"),
            @Result(column = "u_name", property = "uName"),
            @Result(column = "m_name", property = "mName"),
            @Result(column = "introduce", property = "introduce")
        }
    )
    public List<ViewBasicMajorBean> getMajor(@Param("universityID") Integer universityID);
}
