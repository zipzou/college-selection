package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 高校列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UniversityListBean {
    private Integer universityID;
    private String universityName;
    private String logo;
    private String provinceNo;
    private String universityTypes;
    private Boolean if985;
    private Boolean if211;
    private Boolean ifDoubletop;
}
