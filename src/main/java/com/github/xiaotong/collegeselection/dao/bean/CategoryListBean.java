package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业类别列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoryListBean {
    private Short subCategoryCode;
    private Short mCategoryCode;
    private String mCategoryName;
}
