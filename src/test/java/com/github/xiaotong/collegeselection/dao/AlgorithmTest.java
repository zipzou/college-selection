package com.github.xiaotong.collegeselection.dao;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.service.SelectAlgorithm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j;

/**
 * 算法测试
 */
@SpringBootTest
@Log4j
public class AlgorithmTest {
    private @Autowired SelectAlgorithm test;
    @Test
    public void testGetList() {
        ResponseData<Object> bRankList = test.getBRankList("00000001","61", (short)2020, 7352L,"理科");
        ResponseData<Object> cRankList = test.getCRankList("00000001","61", (short)2020, 7352L,"理科");
        ResponseData<Object> wRankList = test.getWRankList("00000001","61", (short)2020, 7352L,"理科");
        log.info(cRankList);
        log.info(bRankList);
        log.info(wRankList);
    }
}
