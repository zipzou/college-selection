package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.StrenthDisciplineBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 强基计划
 */
public interface StrenthDisciplineDao {
    @Select("select * from strenth_discipline;")
    @Results(
        id="map",
        value={
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "str_enroll_type", property = "strEnrollType"),
            @Result(column = "str_guides", property = "strGuides"),
            @Result(column = "str_qualifications", property = "strQualifications"),
            @Result(column = "str_timetable", property = "strTimeTable"),
            @Result(column = "url", property = "url"),
            @Result(column = "tel", property = "tel")
        }
    )
    public List<StrenthDisciplineBean> selectAll();

    /**
     * 
     */
    @Select("select * from strenth_discipline where u_id = #{id};")
    @ResultMap({"map"})
	public StrenthDisciplineBean selectById(Long id);
}
