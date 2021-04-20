package com.github.xiaotong.collegeselection.dao.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 考生信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentInfoBean {
    private String stuNo;
    private Long userNo;
    private String studentName;
    private String mobile;
    private String provinceNo;
    private String examType;
    private Date examTime;
    private short totalScore;
    private Integer chineseScore;
    private Integer mathematics;
    private Integer foreignlang;
    private Integer physical;
    private Integer chemistry;
    private Integer political;
    private Integer biological;
    private Integer historyScore;
    private Integer geography;
}
