package com.example.comtroller;

import com.example.model.Stu;
import com.example.service.StuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "课程接口")
@RestController
@Slf4j
public class ClassController {
    private final static Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuService stuService;

    @ApiOperation(value = "查询课程" ,  notes="查询全部课程")
    @GetMapping("/findClassAll")
    public List<Stu> findAll() {
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");

        return stuService.findAll();
    }
}
