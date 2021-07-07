package com.xinlei.log4j2demo2.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.db.ColumnMapping;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Log4j2Configuration implements ApplicationListener<ContextRefreshedEvent> {
    private final DataSource dataSource;

    public Log4j2Configuration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final ColumnConfig[] cc = {
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("CLASS")
                        .setPattern("%c")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("METHOD")
                        .setPattern("%M")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("THREAD")
                        .setPattern("%t")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("LEVEL")
                        .setPattern("%p")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("LINE")
                        .setPattern("%l")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("MSG")
                        .setPattern("%m")
                        .setUnicode(false)
                        .build(),
                ColumnConfig.newBuilder().setConfiguration(ctx.getConfiguration()).setName("CREATE_TIME")
                        .setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS}")
                        .setUnicode(false)
                        .build()
        };

        //配置appender
        final Appender appender = JdbcAppender
                .newBuilder()
                .setName("databaseAppender")
                .setIgnoreExceptions(false)
                .setConnectionSource(new ConnectionFactory(dataSource))
                .setTableName("cps_sys_log")
                .setColumnConfigs(cc)
                .setColumnMappings(new ColumnMapping[0])
                .build();
        appender.start();

        ctx.getConfiguration().addAppender(appender);
        //指定哪些logger输出的日志保存在mysql中
        ctx.getConfiguration().getLoggerConfig("org.mybatis").addAppender(appender, null, null);
        ctx.getConfiguration().getLoggerConfig("org.springframework").addAppender(appender, null, null);
        ctx.getConfiguration().getLoggerConfig("com.alibaba.dubbo").addAppender(appender, null, null);
        ctx.getConfiguration().getLoggerConfig("druid.sql").addAppender(appender, null, null);
        ctx.getConfiguration().getLoggerConfig("com.xinlei").addAppender(appender,null,null);
        ctx.updateLoggers();
    }
}
