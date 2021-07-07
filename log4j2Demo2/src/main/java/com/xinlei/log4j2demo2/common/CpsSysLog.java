package com.xinlei.log4j2demo2.common;

import lombok.Data;

import java.util.Date;

@Data
public class CpsSysLog {
    private int id;
    private String cla;
    private String method;
    private String thread;
    private String level;
    private String line;
    private String msg;
    private Date createTime;
}
