package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业热榜
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MajorsHotBean {
    private String majorName;
    private Long clickRate;
    private String majorCode;
}
