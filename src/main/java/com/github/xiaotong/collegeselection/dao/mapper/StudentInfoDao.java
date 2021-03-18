package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.StudentInfoBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 考生信息
 */
public interface StudentInfoDao {
    @Select("select * from student_info;")
    @Results(
        {
            @Result(column = "stu_no", property = "stuNo"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "stu_name", property = "studentName"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "exam_type", property = "examType"),
            @Result(column = "exam_time", property = "examTime"),
            @Result(column = "total_score", property = "totalScore"),
            @Result(column = "chinese_score", property = "chineseScore"),
            @Result(column = "mathematics", property = "mathematics"),
            @Result(column = "foreignlang", property = "foreignlang"),
            @Result(column = "physical", property = "physical"),
            @Result(column = "chemistry", property = "chemistry"),
            @Result(column = "political", property = "political"),
            @Result(column = "biological", property = "biological"),
            @Result(column = "history_score", property = "historyScore"),
            @Result(column = "geography", property = "geography")
        }
    )
    public List<StudentInfoBean> selectAll();
}
