package com.example.demo.entity;

import com.example.demo.Gongju.TextSql;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.IfSqlNode;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author wyh
 * @date 2020/5/14 0014
 */
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MybatisInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("拦截器执行");
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object paramObject = args[1];
        BoundSql boundSql = statement.getBoundSql(paramObject);
        String sql = boundSql.getSql();
        String sqlType = statement.getSqlCommandType().toString();
        String sqlResource = statement.getResource();
        DynamicContext context = new DynamicContext(statement.getConfiguration(),paramObject);
        logger.info("SQL语句所在xml文件:"+sqlResource);
        logger.info("SQL语句:" + sql);
        logger.info("SQL类型:" + sqlType);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.warn(properties.toString());
    }
}
