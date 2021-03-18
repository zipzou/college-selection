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
@Getter
@Setter
@ToString
public class BasicMajorBean {
    private Integer universityID;
    private String majorCode;
    private String majorIntro;
}
