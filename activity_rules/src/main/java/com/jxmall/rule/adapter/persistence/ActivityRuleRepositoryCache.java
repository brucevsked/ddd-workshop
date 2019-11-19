package com.jxmall.rule.adapter.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.rule.domain.aggregate.rule.ActivityRuleRepository;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

import org.springframework.stereotype.Repository;

@Repository
public class ActivityRuleRepositoryCache implements ActivityRuleRepository{

    private static List<ActivityRule> dataList = new ArrayList<ActivityRule>();

    static {
        dataList.add(new ActivityRule(UUID.randomUUID().toString(), "李白", "zs@thoughtworks.com", "广东.深圳.南山", 30,
                new String[] { "IT男", "男", "宅男" }));
        dataList.add(new ActivityRule(UUID.randomUUID().toString(), "杜甫", "ls@thoughtworks.com", "广东.深圳.龙岗", 16,
                new String[] { "用户体验设计师", "女", "时尚达人" }));
        dataList.add(new ActivityRule(UUID.randomUUID().toString(), "王维", "zd@thoughtworks.com", "广东.深圳.罗湖", 28,
                new String[] { "业务需求分析师", "女", "美装达人" }));
        dataList.add(new ActivityRule(UUID.randomUUID().toString(), "白居易", "bjy@thoughtworks.com", "广东.深圳.盐田", 32,
                new String[] { "项目经理", "男", "美食达人" }));
        dataList.add(new ActivityRule(UUID.randomUUID().toString(), "陆游", "ly@thoughtworks.com", "广东.深圳.坪山", 34,
                new String[] { "质量保障师", "男", "职场老者" }));
    }

    public List<ActivityRule> search(String key) {
        return dataList.stream()
                .filter(ActivityRule -> Arrays.asList(ActivityRule.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(ActivityRule ActivityRule) {
        dataList.add(ActivityRule);   
    }

    public ActivityRule findById(String id) {
        return dataList.stream()
                .filter(ActivityRule -> id.equals(ActivityRule.getId()))
                .findFirst()
                .orElse(null);
    }
}
