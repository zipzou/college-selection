package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业特殊要求
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SpecialRequirementsBean {
    private short srYear;
    private String majorCode;
    private String requirement;
}
