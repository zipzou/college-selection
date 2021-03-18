package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollHistoryBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年招生计划视图
 */
public interface ViewEnrollHistoryDao {
    @Select("select * from view_enroll_history;")
    @Results(id = "enroll",value = 
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "university_name", property = "universityName"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "major_name", property = "majorName"),
            @Result(column = "years", property = "years"),
            @Result(column = "batch_no", property = "batchNo"),
            @Result(column = "plan_category", property = "planCategory"),
            @Result(column = "family", property = "family"),
            @Result(column = "plan_num", property = "planNum"),
            @Result(column = "tuitionfee", property = "tuitionfee"),
            @Result(column = "school_system", property = "schoolSystem"),
            @Result(column = "memo", property = "memo")
        }
    )
    public List<ViewEnrollHistoryBean> selectAll();

    //根据省份id找到的招生计划
    @Select("select * from view_enroll_history where province_no = #{pNo};")
    @ResultMap(value = "enroll")
    public List<ViewEnrollHistoryBean> getProvinceEnroll(@Param("pNo") String pNo);

    //根据大学id找到的招生计划
    @Select("select * from view_enroll_history where university_id = #{id};")
    @ResultMap(value = "enroll")
    public List<ViewEnrollHistoryBean> getUniversityEnroll(@Param("id") Integer id);

    //根据大学id和省份id找到的招生计划
    @Select("select * from view_enroll_history where university_id = #{id} and province_no = #{pNo};")
    @ResultMap(value = "enroll")
    public List<ViewEnrollHistoryBean> getSpecificEnroll(@Param("id") Integer id,@Param("pNo") String pNo);

    //根据省份id和专业id找到的招生计划
    @Select("select * from view_enroll_history where province_no = #{pNo} and major_code = #{mCode};")
    @ResultMap(value = "enroll")
    public List<ViewEnrollHistoryBean> getMajorEnroll(@Param("pNo") String pNo,@Param("mCode") String mCode);
}
