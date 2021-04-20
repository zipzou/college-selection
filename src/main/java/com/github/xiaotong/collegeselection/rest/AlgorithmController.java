package com.github.xiaotong.collegeselection.rest;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.service.SelectAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 志愿填报
 */

@RestController
@RequestMapping("/volunteer")
public class AlgorithmController {
    private @Autowired SelectAlgorithm service;

    /**
     * 查看志愿填报结果
     * @param userNo
     * @param pNo
     * @param years
     * @param uRanking
     * @param planCate
     * @param mark
     * @return
     */
    @GetMapping("/report/{userNo}/{pNo}/{years}/{uRanking}/{planCate}/{mark}")
    public ResponseData<Object> getReport(@PathVariable Long userNo,@PathVariable String pNo,@PathVariable Short years,@PathVariable Long uRanking,@PathVariable String planCate,@PathVariable String mark)
    {
        if(planCate.equals("w"))//文科
        {
            planCate = "文科";
        }
        else if(planCate.equals("l"))//理科
        {
            planCate = "理科";
        } 
        else if(planCate.equals("z"))//综合
        {
            planCate = "综合";
        }
        else{
            return ResponseData.successF("用户高考类型错误！");
        }
        if(null == mark)
        {
            return ResponseData.successF("列表类型为空！");
        }
        else if(mark.equals("c"))//冲一冲
        {
            ResponseData<Object> results = service.getCRankList(userNo,pNo, years, uRanking, planCate);
            return results;
        }
        else if(mark.equals("b"))//保底
        {
            ResponseData<Object> results = service.getBRankList(userNo,pNo, years, uRanking, planCate);
            return results;
        }
        else if(mark.equals("w"))//稳一稳
        {
            ResponseData<Object> results = service.getWRankList(userNo,pNo, years, uRanking, planCate);
            return results;
        }
        else{
            return ResponseData.successF("列表类型错误！");
        }
    }

    
}

