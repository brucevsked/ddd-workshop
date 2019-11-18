package com.jxmall.activity.qualification.domain.aggregate.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityQualificationRepository {

    private static List<ActivityQualification> dataList = new ArrayList<ActivityQualification>();
    
    static {
        dataList.add(new ActivityQualification(UUID.randomUUID().toString(), "李白", "zs@thoughtworks.com", "广东.深圳.南山", 30,
                new String[] { "IT男", "男", "宅男" }));
        dataList.add(new ActivityQualification(UUID.randomUUID().toString(), "杜甫", "ls@thoughtworks.com", "广东.深圳.龙岗", 16,
                new String[] { "用户体验设计师", "女", "时尚达人" }));
        dataList.add(new ActivityQualification(UUID.randomUUID().toString(), "王维", "zd@thoughtworks.com", "广东.深圳.罗湖", 28,
                new String[] { "业务需求分析师", "女", "美装达人" }));
        dataList.add(new ActivityQualification(UUID.randomUUID().toString(), "白居易", "bjy@thoughtworks.com", "广东.深圳.盐田", 32,
                new String[] { "项目经理", "男", "美食达人" }));
        dataList.add(new ActivityQualification(UUID.randomUUID().toString(), "陆游", "ly@thoughtworks.com", "广东.深圳.坪山", 34,
                new String[] { "质量保障师", "男", "职场老者" }));
    }

    public List<ActivityQualification> search(String key) {
        if(Strings.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream()
                .filter(activityQualification -> Arrays.asList(activityQualification.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(ActivityQualification activityQualification) {
        dataList.add(activityQualification);
    }

    public ActivityQualification findById(String id) {
        return dataList.stream()
                .filter(activityQualification -> id.equals(activityQualification.getId()))
                .findFirst()
                .orElse(null);
    }
}
