package com.github.xiaotong.collegeselection.dao.mapper;

import org.apache.ibatis.annotations.Results;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewCompeValuationBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * 综合测评视图
 */
public interface ViewCompeValuationDao {
    @Select("select * from view_compevaluation;")
    @Results(id = "viewCom",value = 
        {
            @Result(column = "u_id", property = "uID"),
            @Result(column = "u_name", property = "uName"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "enroll_type", property = "enrollType"),
            @Result(column = "guides", property = "guides"),
            @Result(column = "qualifications", property = "qualifications"),
            @Result(column = "timetable", property = "timetable"),
            @Result(column = "url", property = "url"),
            @Result(column = "tel", property = "tel")
        }
    )
    public List<ViewCompeValuationBean> selectAll();

    /**
     * 综合测评高校列表
     */
    @Select("select u_id,u_name,logo,province_no from view_compevaluation;")
    @Results(
        {
            @Result(column = "u_id", property = "universityID"),
            @Result(column = "u_name", property = "universityName"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "province_no", property = "provinceNo"),
        }
    )
    public List<UListBean> getCompUniversityList();

    /**
     * 通过id查询具体学校的综合测评
     */
    @Select("select * from view_compevaluation where u_id = #{universityID};")
    @ResultMap(value = "viewCom")
    public ViewCompeValuationBean getCompByID(@Param("universityID") Integer universityID);
}
