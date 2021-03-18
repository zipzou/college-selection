package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 宣讲视频列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VideoListBean {
    private Integer videoID;
    private String videoTitle;
    private String videoLabel;
}
