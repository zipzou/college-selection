package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewStrenthBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 强基计划视图
 */
public interface ViewStrenthDao {
    @Select("select * from view_strenth_discipline;")
    @Results(id="viewStrenth",value = 
        {
            @Result(column = "u_id", property = "uID"),
            @Result(column = "u_name", property = "uName"),
            @Result(column = "enroll_type", property = "enrollType"),
            @Result(column = "guides", property = "guides"),
            @Result(column = "qualifications", property = "qualifications"),
            @Result(column = "timetable", property = "timeTable"),
            @Result(column = "url", property = "url"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "logo", property = "logo")
        }
    )
    public List<ViewStrenthBean> selectAll();
    
    /**
     * 强基计划高校列表
     */
    @Select("select u_id,u_name,logo,province_no from view_strenth_discipline;")
    @Results(
        {
            @Result(column = "u_id", property = "universityID"),
            @Result(column = "u_name", property = "universityName"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "province_no", property = "provinceNo"),
        }
    )
    public List<UListBean> getStrUniversityList();

    /**
     * 通过id查询具体学校的强基计划
     */
    @Select("select * from view_strenth_discipline where u_id = #{universityID};")
    @ResultMap(value = "viewStrenth")
    public ViewStrenthBean getStrenthByID(@Param("universityID") Integer universityID);
}
