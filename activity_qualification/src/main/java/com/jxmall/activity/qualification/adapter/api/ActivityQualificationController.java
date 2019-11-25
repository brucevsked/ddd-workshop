package com.jxmall.activity.qualification.adapter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import com.jxmall.activity.qualification.application.ActivityQualificationApplication;
import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

@RestController
@RequestMapping("/jxmall/activity_qualifications")
@Slf4j
public class ActivityQualificationController {

    @Autowired
    private ActivityQualificationApplication activityQualificationApplication;

    @RequestMapping
    public ResponseEntity<List<ActivityQualification>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityQualificationApplication.search(key));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ActivityQualification activitie) {
        activityQualificationApplication.create(activitie);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/activity_qualifications/{id}")
                .buildAndExpand(activitie.getId()).toUri()).build();
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<ActivityQualification> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityQualificationApplication.findById(id));
    }

    @RequestMapping(path = "/current-date")
    public ResponseEntity<ActivityQualification> getCurrentActivityQualification() {
        log.debug("current-data");
        return ResponseEntity.ok(activityQualificationApplication.getCurrentActivityQualification());
    }
}