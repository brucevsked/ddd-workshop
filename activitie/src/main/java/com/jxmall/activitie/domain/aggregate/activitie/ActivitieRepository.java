package com.jxmall.activitie.domain.aggregate.activitie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activitie.domain.aggregate.activitie.root.Activitie;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

@Repository
public class ActivitieRepository {

    private static List<Activitie> dataList = new ArrayList<Activitie>();

    static {
        dataList.add(new Activitie(UUID.randomUUID().toString(), "IT论坛", "IT界精英齐聚一趟，交流技术，产生共鸣", "广东.深圳.南山",
                new String[] { "IT", "技术论坛", "技术交流" }));
        dataList.add(new Activitie(UUID.randomUUID().toString(), "技术峰会", "技术峰会，邀请业界技术大牛参与", "广东.深圳.罗湖",
                new String[] { "IT", "峰会", "技术论坛", "技术交流" }));
        dataList.add(new Activitie(UUID.randomUUID().toString(), "Ruby技术交流", "Ruby是世界上最好的开发语言，由华为发起", "广东.深圳.福田",
                new String[] { "IT", "Ruby", "PHP", "编程语言", "华为" }));
        dataList.add(new Activitie(UUID.randomUUID().toString(), "DDD Workshop", "领域驱动设计，Thoughtworks一直致力于微服务的推广", "广东.深圳.盐田",
                new String[] { "IT", "DDD", "Workshop", "微服务", "Workshop" }));
    }

    public List<Activitie> search(String key) {
        if(Strings.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream()
                .filter(activitie -> Arrays.asList(activitie.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(Activitie activitie) {
        dataList.add(activitie);
    }

    public Activitie findById(String id) {
        return dataList.stream()
                .filter(activitie -> id.equals(activitie.getId()))
                .findFirst()
                .orElse(null);
    }
}
