package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CollectionMajorBean;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 个人收藏
 */
public interface CollectionMajorDao {
    @Select("select c.major_code,user_no,major_name from collection_major as c,majors_info as m where user_no = #{userNo} and c.major_code = m.major_code;")
    @Results(id = "majorCollection",value = 
        {
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "major_name", property = "mName"),
        }
    )
    public List<CollectionMajorBean> getMajorCollection(@Param("userNo") String userNo);

    /**
     * 获得单独的一个收藏
     * @param majorCode
     * @param userNo
     * @return
     */
    @Select("select * from collection_major where major_code = #{majorCode} and user_no = #{userNo};")
    @ResultMap(value = "majorCollection")
    public CollectionMajorBean getAnMajorCollection(@Param("majorCode") String majorCode,@Param("userNo") String userNo);
    
    /**
     * 插入个人专业收藏
     */
    @Insert("INSERT into collection_major(major_code,user_no) VALUES(#{majorCode},#{userNo});")
    public void insertMajorCollect(@Param("majorCode") String majorCode,@Param("userNo") String userNo);

    /**
     * 取消个人专业收藏
     * @param majorCode
     * @param userNo
     */
    @Delete("delete from collection_major where major_code = #{majorCode} and user_no = #{userNo};")
    public void deleteMajorCollect(@Param("majorCode") String majorCode,@Param("userNo") String userNo);
}
