package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CategoryListBean;
import com.github.xiaotong.collegeselection.dao.bean.MajorListBean;
import com.github.xiaotong.collegeselection.dao.bean.SubCategoryListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewMajorsInfoBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import lombok.experimental.PackagePrivate;

/**
 * 专业介绍视图
 */
public interface ViewMajorsInfoDao {
    @Select("select * from view_majors_info;")
    @Results(id="viewMajors",value = 
        {
            @Result(column = "m_year", property = "mYear"),
            @Result(column = "m_code", property = "mCode"),
            @Result(column = "m_category_code", property = "mCategoryCode"),
            @Result(column = "m_name", property = "mName"),
            @Result(column = "m_memo", property = "mMemo"),
            @Result(column = "m_category_name", property = "mCategoryName"),
            @Result(column = "m_requ", property = "mRequ"),
            @Result(column = "sub_name", property = "subName"),
            @Result(column = "sub_code", property = "subCode")
        }
    )
    public List<ViewMajorsInfoBean> getAll();

    //得到类别列表
    @Select("select distinct sub_code,sub_name from view_majors_info;")
    @Results(
        {
            @Result(column = "sub_name", property = "subCategoryName"),
            @Result(column = "sub_code", property = "subCategoryCode")
        }
    )
    public List<SubCategoryListBean> getSubList();

    //根据学科门类类别id展出该类下面的专业类别列表
    @Select("select distinct sub_code,m_category_code,m_category_name from view_majors_info where sub_code = #{subCode};")
    @Results(
        {
            @Result(column = "sub_code", property = "subCategoryCode"),
            @Result(column = "m_category_code", property = "mCategoryCode"),
            @Result(column = "m_category_name", property = "mCategoryName"),
        }
    )
    public List<CategoryListBean> getCategoryListByID(@Param("subCode") Short subCode);

    /**
     * 根据学科门类和专业类别得到专业列表
     */
    @Select("select m_name,m_code from view_majors_info where sub_code = #{subCode} and m_category_code = #{mCateCode}")
    @Results(
        {
            @Result(column = "m_code", property = "majorCode"),
            @Result(column = "m_name", property = "majorName")
        }
    )
    public List<MajorListBean> getMajorList(@Param("subCode")Short subCode,@Param("mCateCode") Short mCateCode);

    //根据学科门类类别id和专业类别id以及专业id得到专业信息
    @Select("select * from view_majors_info where sub_code = #{subCode} and m_category_code = #{mCateCode} and m_code = #{mCode};")
    @ResultMap(value = "viewMajors")
    public ViewMajorsInfoBean getAnMajor(@Param("subCode") Short subCode,@Param("mCateCode") Short mCateCode,@Param("mCode") String mCode);
}
