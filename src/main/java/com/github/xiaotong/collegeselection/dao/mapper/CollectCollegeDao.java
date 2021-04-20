package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CollectionCollegeBean;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 大学收藏
 */
public interface CollectCollegeDao {
    @Select("select c.university_id,user_no,university_name from collection_college as c,university_info as u where user_no = #{userNo} and c.university_id = u.university_id;")
    @Results(id = "uCollection",value = 
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "university_name", property = "uName"),
        }
    )
    public List<CollectionCollegeBean> getCollegeCollection(@Param("userNo") Long userNo);

    /**
     * 获得指定用户指定大学的收藏
     * @param userNo
     * @param universityID
     * @return
     */
    @Select("select * from collection_college where university_id = #{universityID} and user_no = #{userNo};")
    @ResultMap(value = "uCollection")
    public CollectionCollegeBean getAnCollegeCollection(@Param("userNo") Long userNo,@Param("universityID") Integer universityID);
    
    /**
     * 添加个人大学收藏
     */
    @Insert("INSERT into collection_college(university_id,user_no) VALUES(#{universityID},#{userNo});")
    public void insertCollegeCollect(@Param("universityID") Integer universityID,@Param("userNo") Long userNo);
    
    /**
     * 删除个人大学收藏
     * @param universityID
     * @param userNo
     */
    @Delete("delete from collection_college where university_id = #{universityID} and user_no = #{userNo};")
    public void deleteCollegeCollect(@Param("universityID") Integer universityID,@Param("userNo") Long userNo);
}
