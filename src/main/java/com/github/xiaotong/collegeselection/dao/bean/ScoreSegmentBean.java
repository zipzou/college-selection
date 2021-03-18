package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 一分一段
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScoreSegmentBean {
    private String provinceNo;
    private String provinceName;
    private short years;
    private String stuCategory;
    private short score;
    private short numbers;
    private Integer ranks;
}
