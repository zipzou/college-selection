package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 学校基本信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UniversityInfoBean {
    private Integer universityID;
    private Long clickRate;
    private String provinceNo;
    private String universityCode;
    private String universityName;
    private String location;
    private String administrat;
    private String universityIntro;
    private String universityTypes;
    private Boolean ifDoubletop;
    private Boolean ifDoublemajors;
    private Boolean if985;
    private Boolean if211;
    private String website;
    private String recruitsite;
    private String charact;
    private String logo;
    private String schoolLevel;
    private String address;
    private Integer postalCode;
    private String schoolType;
    private String specialProfession;
    private Integer masters;
    private Integer doctorals;
    private String university_memo;
}
