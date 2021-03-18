package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EvaluatMajorBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 综合测评专业
 */
public interface EvaluatMajorDao {
    @Select("select * from evaluat_major;")
    @Results(
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "major_intro", property = "majorIntro")
        }
    )
    public List<EvaluatMajorBean> selectAll();
}
