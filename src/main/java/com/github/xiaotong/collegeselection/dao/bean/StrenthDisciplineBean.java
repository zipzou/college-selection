package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 强基计划
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StrenthDisciplineBean {
    private Integer universityID;
    private String strEnrollType;
    private String strGuides;
    private String strQualifications;
    private String strTimeTable;
    private String url;
    private String tel;
}
