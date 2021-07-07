package com.xinlei.log4j2demo2.service;

import com.xinlei.log4j2demo2.common.CpsSysLog;
import com.xinlei.log4j2demo2.mapper.GetLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLogServiceImpl {
    @Autowired
    private GetLogMapper getLog;
    public List<CpsSysLog> getAllLog() {
        return getLog.getAllLog();
    }
}
