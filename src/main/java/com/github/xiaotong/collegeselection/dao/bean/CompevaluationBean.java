package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 综合测评
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CompevaluationBean {
    private Integer universityID;
    private String enrollType;
    private String guides;
    private String qualifications;
    private String timetable;
    private String url;
    private String tel;
}
