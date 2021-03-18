package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 大学热榜
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UniversityHotBean {
    private Integer universityID;
    private Long clickRate;
    private String universityName;
}
