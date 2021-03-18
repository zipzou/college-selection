package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.SubjectCategoryBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 学科门类
 */
public interface SubjectCategoryDao {
    @Select("select * from subject_category;")
    @Results(
        {
            @Result(column = "subcategory_code", property = "subCategoryCode"),
            @Result(column = "sub_category", property = "subCategory"),
            @Result(column = "major_category", property = "majorCategory")
        }
    )
    public List<SubjectCategoryBean> selectAll();
}
