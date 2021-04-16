package com.github.xiaotong.collegeselection.rest;

import com.github.xiaotong.collegeselection.body.CollectParam;
import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.service.CollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * 个人中心
 */
@RestController
@Log4j
@RequestMapping("/user")
public class PersonalCenterController {
    private @Autowired CollectionService service;
    /**
     * 大学收藏
     * @param id
     * @return
     */
    @GetMapping("/collection_college/{id}")
    public ResponseData<Object> getCollegeCollection(@PathVariable String id) {
        ResponseData<Object> results = service.getCollegeCollection(id);
        log.info(results);
        return results;
    }

    /**
     * 得到专业收藏
     */
    @GetMapping("/collection_major/{id}")
    public ResponseData<Object> getMajorCollection(@PathVariable String id) {
        ResponseData<Object> results = service.getMajorsCollection(id);
        log.info(results);
        return results;
    }
    
    /**
     * 得到视频收藏
     * @param id
     * @return
     */
    @GetMapping("/collection_video/{id}")
    public ResponseData<Object> getVideoCollection(@PathVariable String id) {
        ResponseData<Object> results = service.getVideoCollection(id);
        log.info(results);
        return results;
    }

    /**
     * 获得志愿填报
     * @param userNo
     * @param mark
     * @return
     */
    @GetMapping("/report_collection/{userNo}/{mark}")
    public ResponseData<Object> getReportCollection(@PathVariable String userNo,@PathVariable String mark)
    {
        ResponseData<Object> results = service.getReportCollect(userNo, mark);
        return results;
    }
    /**
     * 往数据库插入新收藏
     * @param collect
     * @return
     */
    @PostMapping("/collect")
    public ResponseData<Object> updateCollectData(@RequestBody CollectParam collect)
    {
        String userNo = collect.getUserNo();
        String code = collect.getCode();
        String mark = collect.getMark();
        if(!code.isEmpty())
        {
            if(mark.equals("m"))//专业的收藏
            {
                return service.insertMajorCollect(code,userNo);
            }
            else if(mark.equals("v"))//视频的收藏
            {
                return service.insertVideoCollect(Integer.parseInt(code),userNo);
            }
            else if(mark.equals("u"))//大学收藏
            {
                return service.insertCollegeCollect(Integer.parseInt(code), userNo);
            }
            else
            {
                return ResponseData.successF("mark参数不正确！");
            }
        }
        else{
            return ResponseData.successF("code参数为空！");
        }
    }

    /**
     * 删除收藏
     * @param collect
     * @return
     */
    @PostMapping("/delete_collect")
    public ResponseData<Object> deleteCollectData(@RequestBody CollectParam collect)
    {
        String userNo = collect.getUserNo();
        String code = collect.getCode();
        String mark = collect.getMark();
        if(!code.isEmpty())
        {
            if(mark.equals("m"))//专业的收藏
            {
                return service.deleteMajorCollect(code, userNo);
            }
            else if(mark.equals("v"))//视频的收藏
            {
                return service.deleteVideoCollect(Integer.parseInt(code), userNo);
            }
            else if(mark.equals("u"))//大学收藏
            {
                return service.deleteCollegeCollect(Integer.parseInt(code), userNo);
            }
            else
            {
                return ResponseData.successF("mark参数不正确！");
            }
        }
        else{
            return ResponseData.successF("code参数为空！");
        }
    }
}
