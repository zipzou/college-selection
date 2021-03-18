package com.github.xiaotong.collegeselection.rest;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.body.UpdateRateParam;
import com.github.xiaotong.collegeselection.dao.bean.MajorsHotBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityHotBean;
import com.github.xiaotong.collegeselection.service.MajorsInfoService;
import com.github.xiaotong.collegeselection.service.UniversityInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 热榜
 */
@RestController
@RequestMapping("/hot")
public class HotListController {
    
    private @Autowired UniversityInfoService universityService;
    private @Autowired MajorsInfoService majorsInfoService;
    
    /**
     * 增加概率
     * @param update
     * @return
     */
    @PostMapping("/update")
    public ResponseData<Object> updateRate(@RequestBody UpdateRateParam update)
    {
        if(!update.getCode().isEmpty())
        {
            if(update.getMark().equals("m"))//专业的
            {
                return majorsInfoService.updateRate(update.getCode());
            }
            else if(update.getMark().equals("u"))//学校的
            {
                return universityService.updateRate(Integer.parseInt(update.getCode()));
            }
            else{//这个参数不对
                return ResponseData.successF("mark参数不正确！");
            }
        }
        else{
            return ResponseData.successF("code参数为空！");
        }
    }

    /**
     * 高校热榜
     * @return
     */
    @GetMapping("/u_hotlist")
    public ResponseData<Object> getUniversityHotList(){
        List<UniversityHotBean> results = universityService.getUniversityHot();
        if(results.isEmpty())
        {
            return ResponseData.failed("还没有数据！");
        }
        else{
            return ResponseData.success(results);
        }
    }

    /**
     * 专业热榜
     * @return
     */
    @GetMapping("/m_hotlist")
    public ResponseData<Object> getMajorsHotList(){
        List<MajorsHotBean> results = majorsInfoService.getMajorsHot();
        if(results.isEmpty())
        {
            return ResponseData.failed("还没有数据！");
        }
        else{
            return ResponseData.success(results);
        }
    }
}
