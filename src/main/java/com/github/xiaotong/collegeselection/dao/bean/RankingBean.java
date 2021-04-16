package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 录取位次
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RankingBean {
    private Long avgRanking;
    private Long minRanking;
}
