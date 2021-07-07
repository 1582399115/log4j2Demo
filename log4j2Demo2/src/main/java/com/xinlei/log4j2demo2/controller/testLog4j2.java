package com.xinlei.log4j2demo2.controller;

import com.xinlei.log4j2demo2.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@Slf4j
public class testLog4j2 {
    @GetMapping("/test")
    public Result testLog() {
        System.out.println("测试日志");
        log.info("info日志");
        log.warn("warn日志");
        log.debug("debug日志");
        log.error("error日志");
        return Result.getSuccess();
    }
}
