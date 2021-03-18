package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 招生专业
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MajorBean {
    private Integer universityID;
    private String majorCode;
    private String levels;
    private String schoolSystem;
    private short tuitionfee;
    private String ranking;
    private String requirements;
    private Integer jobsType;
}
