package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 大学收藏
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CollectionCollegeBean {
    private String userNo;
    private Integer universityID;
    private String uName;
}
