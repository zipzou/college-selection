package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.UniversityHotBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityInfoBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityListBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 学校基本信息
 */
public interface UniversityInfoDao {
    @Select("select * from university_info;")
    @Results(id = "university_info",value = 
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "university_code", property = "universityCode"),
            @Result(column = "university_name", property = "universityName"),
            @Result(column = "location", property = "location"),
            @Result(column = "administrat", property = "administrat"),
            @Result(column = "university_intro", property = "universityIntro"),
            @Result(column = "university_types", property = "universityTypes"),
            @Result(column = "if_doubletop", property = "ifDoubletop"),
            @Result(column = "if_doublemajors", property = "ifDoublemajors"),
            @Result(column = "if_985", property = "if985"),
            @Result(column = "if_211", property = "if211"),
            @Result(column = "website", property = "website"),
            @Result(column = "recruitsite", property = "recruitsite"),
            @Result(column = "charact", property = "charact"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "school_level", property = "schoolLevel"),
            @Result(column = "address", property = "address"),
            @Result(column = "postal_code", property = "postalCode"),
            @Result(column = "school_type", property = "schoolType"),
            @Result(column = "special_profession", property = "specialProfession"),
            @Result(column = "masters", property = "masters"),
            @Result(column = "doctorals", property = "doctorals"),
            @Result(column = "university_memo", property = "university_memo"),
            @Result(column = "click_rate", property = "clickRate")
        }
    )
    public List<UniversityInfoBean> selectAll();

    //高校列表
    @Select("select university_name,logo,university_id,province_no,university_types,if_985,if_211,if_doubletop from university_info;")
    @Results(
        {
            @Result(column = "university_name", property = "universityName"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "university_types", property = "universityTypes"),
            @Result(column = "if_985", property = "if985"),
            @Result(column = "if_211", property = "if211"),
            @Result(column = "if_doubletop", property = "ifDoubletop"),
        }
    )
    public List<UniversityListBean> getUniversityList();

    //高校具体信息byID
    @Select("select * from university_info where university_id = #{universityID};")
    @ResultMap(value = "university_info")
    public UniversityInfoBean selectAllByID(@Param("universityID") Integer universityID);

    //更新clickRate
    @Update("update university_info set click_rate = click_rate + 1 where university_id = #{universityID};")
    public void updateRate(@Param("universityID") Integer universityID);

    /**
     * 高校热榜
     * @return
     */
    @Select("select university_id,university_name,click_rate from university_info where click_rate > 0 order by click_rate DESC limit 10;")
    @Results(
        {
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "university_name", property = "universityName"),
            @Result(column = "click_rate", property = "clickRate")
        }
    )
    public List<UniversityHotBean> getHotUniversity();
}
