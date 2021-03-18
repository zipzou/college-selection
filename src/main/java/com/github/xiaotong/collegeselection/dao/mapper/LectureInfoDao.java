package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.LectureInfoBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 讲座信息
 */
public interface LectureInfoDao {
    @Select("select * from lecture_info;")
    @Results(
        {
            @Result(column = "lec_id", property = "lecID"),
            @Result(column = "lec_title", property = "lecTitile"),
            @Result(column = "lec_label", property = "lecLabel"),
            @Result(column = "lec_filepath", property = "lecFilePath"),
            @Result(column = "lec_url", property = "lecUrl")
        }
    )
    public List<LectureInfoBean> selectAll();
}
