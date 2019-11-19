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

@Api(description = "用户接口")
@RestController
@Slf4j
public class StuController {
    private final static Logger logger = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuService stuService;

    @ApiOperation(value = "查询用户" ,  notes="查询全部用户")
    @GetMapping("/findAll")
    public List<Stu> findAll() {
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");

        return stuService.findAll();
    }

    @GetMapping("/selectByExample")
    public List<Stu> selectByExample() {
        return stuService.selectByExample();
    }

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
    @PutMapping("/modify/{id}")
    public int modify(@PathVariable("id") int id, @RequestParam("address") String address) {
        return stuService.modify(id, address);
    }

    @GetMapping("/save")
    public int save() {
        return stuService.save();
    }

}
