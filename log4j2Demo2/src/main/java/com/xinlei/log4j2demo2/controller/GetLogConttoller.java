package com.xinlei.log4j2demo2.controller;

import com.xinlei.log4j2demo2.common.CpsSysLog;
import com.xinlei.log4j2demo2.service.GetLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class GetLogConttoller {
    @Autowired
    private GetLogServiceImpl logService;
    @GetMapping("/getLog")
    @ApiOperation(value = "这是一个获得生成日志的方法")
    public List<CpsSysLog> getLog(){
        List<CpsSysLog> cpsSysLog=logService.getAllLog();
        return cpsSysLog;
    }
}
