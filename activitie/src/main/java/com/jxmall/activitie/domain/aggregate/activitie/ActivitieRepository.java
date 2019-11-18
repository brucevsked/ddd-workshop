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

    private static List<Activitie> activitieList = new ArrayList<Activitie>();

    static {
        activitieList.add(new Activitie(UUID.randomUUID().toString(), "李白", "zs@thoughtworks.com", "广东.深圳.南山", 30,
                new String[] { "IT男", "男", "宅男" }));
        activitieList.add(new Activitie(UUID.randomUUID().toString(), "杜甫", "ls@thoughtworks.com", "广东.深圳.龙岗", 16,
                new String[] { "用户体验设计师", "女", "时尚达人" }));
        activitieList.add(new Activitie(UUID.randomUUID().toString(), "王维", "zd@thoughtworks.com", "广东.深圳.罗湖", 28,
                new String[] { "业务需求分析师", "女", "美装达人" }));
        activitieList.add(new Activitie(UUID.randomUUID().toString(), "白居易", "bjy@thoughtworks.com", "广东.深圳.盐田", 32,
                new String[] { "项目经理", "男", "美食达人" }));
        activitieList.add(new Activitie(UUID.randomUUID().toString(), "陆游", "ly@thoughtworks.com", "广东.深圳.坪山", 34,
                new String[] { "质量保障师", "男", "职场老者" }));
    }

    public List<Activitie> search(String key) {
        if(Strings.isEmpty(key)) {
            return activitieList;
        }
        return activitieList.stream()
                .filter(activitie -> Arrays.asList(activitie.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(Activitie activitie) {
        activitieList.add(activitie);
        System.out.println(activitieList.size());
    }

    public Activitie findById(String id) {
        System.out.println(id);
        System.out.println(activitieList.size());
        return activitieList.stream()
                .filter(activitie -> id.equals(activitie.getId()))
                .findFirst()
                .orElse(null);
    }
}
