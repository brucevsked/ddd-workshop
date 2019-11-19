package com.jxmall.activity.application;

import java.util.List;

import com.jxmall.activity.domain.aggregate.activity.ActivityService;
import com.jxmall.activity.domain.aggregate.activity.root.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityApplication {

    @Autowired
    private ActivityService activityService;

    public List<Activity> search(String key) {
        return activityService.search(key);
    }

    public void create(Activity activity) {
        activityService.create(activity);
    }

    public Activity findById(String id) {
        return activityService.findById(id);
    }
}