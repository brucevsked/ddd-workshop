package com.jxmall.activity.adapter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import com.jxmall.activity.application.ActivityApplication;
import com.jxmall.activity.domain.aggregate.activity.ActivityService;
import com.jxmall.activity.domain.aggregate.activity.root.Activity;

@RestController
@RequestMapping("/jxmall/activities")
public class ActivityController {

    @Autowired
    private ActivityApplication activityApplication;

    @RequestMapping
    public ResponseEntity<List<Activity>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityApplication.search(key));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Activity activity, UriComponentsBuilder builder) {
        activityApplication.create(activity);
        return ResponseEntity.created(builder.path("/jxmall/activitys/{id}").buildAndExpand(activity.getId()).toUri())
                .build();
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<Activity> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityApplication.findById(id));
    }
}