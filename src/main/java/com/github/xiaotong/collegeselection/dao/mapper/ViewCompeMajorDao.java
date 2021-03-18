package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ViewCompeMajorBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 综合测评专业视图
 */
public interface ViewCompeMajorDao {
    @Select("select * from view_compevaluation_major where id = #{universityID};")
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
    public List<ViewCompeMajorBean> getMajor(@Param("universityID") Integer universityID);
}
