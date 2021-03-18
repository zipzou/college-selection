package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 视频库
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VideosInfoBean {
    private Integer videoID;
    private String videoTitle;
    private String videoLabel;
    private String videoFilepath;
    private String videoUrl;
}
