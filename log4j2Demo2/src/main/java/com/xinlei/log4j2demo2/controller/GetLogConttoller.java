package com.xinlei.log4j2demo2.controller;

import com.xinlei.log4j2demo2.common.CpsSysLog;
import com.xinlei.log4j2demo2.service.GetLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
@Slf4j
public class GetLogConttoller {
    @Autowired
    private GetLogServiceImpl logService;
    @GetMapping("/getLog")
    @ApiOperation(value = "这是一个获得生成日志的方法")
    public List<CpsSysLog> getLog(){
        List<CpsSysLog> cpsSysLog=logService.getAllLog();
        log.info("这是一个获得生成日志的方法");
        log.debug("这是一个获得生成日志的方法debug测试");
        log.warn("这是一个获得生成日志的方法warn测试");
        log.error("这是一个获得生成日志的方法error测试");
        return cpsSysLog;
    }
}
