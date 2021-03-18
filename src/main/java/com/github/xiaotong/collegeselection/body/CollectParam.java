package com.github.xiaotong.collegeselection.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 添加收藏功能
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CollectParam {
    private String code;
    private String mark;//如果是u，那就说明code是大学id，如果是m，那就说明code是专业id,如果是v，那就是视频id 
    private String userNo;
}
