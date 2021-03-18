package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.BasicMajorBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 强基计划
 */
public interface BasicMajorDao {
    @Select("select * from basic_major;")
    @Results(id="BasicMajorMap",value = 
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "major_intro", property = "majorIntro")
        }
    )
    public List<BasicMajorBean> selectAll();
    
    //强基计划专业介绍--通过高校id和专业代码
    @Select("select major_intro from basic_major where university_id = #{universityID} and major_code = #{majorCode};")
    public String getMajorIntro(@Param("universityID") Integer universityID,@Param("majorCode")String majorCode);
    
    //强基计划专业列表--通过高校id
    @Select("select major_code from basic_major where university_id = #{universityID};")
    public List<Integer> getMajorList(@Param("universityID") Integer universityID);
    
}
