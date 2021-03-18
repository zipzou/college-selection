package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 历年分数线
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ScoreHistoryBean {
    private String provinceName;
    private String provinceNo;
    private short years;
    private String batchNo;
    private Integer comprehensive;
    private Integer arts;
    private Integer science;
}
