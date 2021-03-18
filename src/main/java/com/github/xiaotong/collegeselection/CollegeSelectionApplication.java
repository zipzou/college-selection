package com.github.xiaotong.collegeselection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 项目启动类
 */
@SpringBootApplication
@MapperScan("com.github.xiaotong.collegeselection.dao.mapper")
public class CollegeSelectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeSelectionApplication.class, args);
	}

}
