/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: MyDataflowJob.java
 * Author:   88395515
 * Date:     2019/12/23  20:16
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.elastic.job.exc;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.elastic.job.dmo.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 20:16 2019/12/23
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class MyDataflowJob implements DataflowJob<Person> {
    /**
     * 抓取
     *
     * @param shardingContext
     * @return
     */
    @Override
    public List<Person> fetchData(ShardingContext shardingContext) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setAge(i);
            p.setName("w" + i + "s");
            personList.add(p);
        }

        return personList;
    }

    /**
     * 处理
     *
     * @param shardingContext
     * @param list
     */
    @Override
    public void processData(ShardingContext shardingContext, List<Person> list) {
        for (Person person : list) {
            System.out.println("获取的姓名：" + person.getName() + "年龄：" + person.getAge());
        }
    }
}
