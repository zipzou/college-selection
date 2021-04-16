package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 大学的录取概率
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EnrollRankingBean {
    private Integer uID;
    private Double ranking;
    private String mark;//冲、稳、保的标志
}
