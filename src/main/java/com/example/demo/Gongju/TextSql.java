package com.example.demo.Gongju;

import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.apache.ibatis.scripting.xmltags.SqlNode;

/**
 * @author wyh
 * @date 2020/5/18 0018
 */
public class TextSql implements SqlNode {
    private ExpressionEvaluator evaluator;
    private String test;
    private SqlNode contents;

    public void IfSqlNode(SqlNode contents, String test) {
        this.test = test;
        this.contents = contents;
        this.evaluator = new ExpressionEvaluator();
    }

    @Override
    public boolean apply(DynamicContext context) {
        if (evaluator.evaluateBoolean(test,context.getBindings())){
            contents.apply(context);
            System.out.println(test);
            return true;
        }
        return false;
    }
}
