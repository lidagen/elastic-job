/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: StockSimpleJob.java
 * Author:   88395515
 * Date:     2019/12/23  17:39
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.elastic.job.exc;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 17:39 2019/12/23
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class FirstJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        List<String> list;
        switch (shardingContext.getShardingItem()){
            case 0:
                list = Arrays.asList("A1,A2,A3");
                System.out.println(String.format("--Thread ID：%s,任务总篇数：%s,当前分页片：%s,当前参数：%s," +
                                "当前任务名称：%s,当前任务结果：%s",Thread.currentThread().getId(),shardingContext.getShardingTotalCount(),
                        shardingContext.getShardingItem(),shardingContext.getShardingParameter(),shardingContext.getJobName(),
                        JSON.toJSONString(list)));
                break;
            case 1:
                list = Arrays.asList("B1,B2");
                System.out.println(String.format("--Thread ID：%s,任务总篇数：%s,当前分页片：%s,当前参数：%s," +
                                "当前任务名称：%s,当前任务结果：%s",Thread.currentThread().getId(),shardingContext.getShardingTotalCount(),
                        shardingContext.getShardingItem(),shardingContext.getShardingParameter(),shardingContext.getJobName(),
                        JSON.toJSONString(list)));
                break;
            default:
                System.out.println("do nothing!");
        }

    }
}
