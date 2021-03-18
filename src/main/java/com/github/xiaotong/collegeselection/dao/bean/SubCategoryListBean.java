package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 学科门类列表
 */
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Setter
@Getter
public class SubCategoryListBean {
    private Short subCategoryCode;
    private String subCategoryName; 
}
