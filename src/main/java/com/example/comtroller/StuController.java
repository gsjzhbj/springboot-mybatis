package com.example.comtroller;

import com.example.model.Stu;
import com.example.service.StuService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "学生接口")
@RestController
@Slf4j
public class StuController {
    private final static Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuService stuService;

    @ApiOperation(value = "查询学生" ,  notes="查询全部学生")
    @GetMapping("/findAll")
    public List<Stu> findAll() {
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");

        return stuService.findAll();
    }

    @ApiOperation(value = "查询12岁学生" ,  notes="查询全部12岁学生")
    @GetMapping("/selectByExample")
    public List<Stu> selectByExample() {
        return stuService.selectByExample();
    }

    @ApiOperation(value = "查询12岁学生" ,  notes="查询全部12岁学生，分页返回")
    @GetMapping("/selectByExampleWithPage")
    public PageInfo<Stu> selectByExampleWithPage(int pageNum, int pageSize) {
        return stuService.selectByExampleWithPage(pageNum, pageSize);
    }

    /**
     * 测试修改，并且使用restful风格
     *
     * @param id
     * @param address
     * @return
     */
    @ApiOperation(value = "修改学生" ,  notes="修改学生地址信息")
    @PutMapping("/modify/{id}")
    public int modify(@PathVariable("id") int id, @RequestParam("address") String address) {
        return stuService.modify(id, address);
    }

    @ApiOperation(value = "保存学生" ,  notes="保存学生信息")
    @GetMapping("/save")
    public int save() {
        return stuService.save();
    }

}
