package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 综合测评专业
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EvaluatMajorBean {
    private Integer universityID;
    private String majorCode;
    private String majorIntro;
}
