package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 学科门类
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SubjectCategoryBean {
    private short subCategoryCode;
    private String subCategory;
    private short majorCategory;
}
