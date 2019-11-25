package com.jxmall.activity.benefit.adapter.api;

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

import com.jxmall.activity.benefit.application.ActivityBenefitApplication;
import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

@RestController
@RequestMapping("/jxmall/activity_benefits")
@Slf4j
public class ActivityBenefitController {

    @Autowired
    private ActivityBenefitApplication activityBenefitApplication;

    @RequestMapping
    public ResponseEntity<List<ActivityBenefit>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityBenefitApplication.search(key));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ActivityBenefit activitie) {
        activityBenefitApplication.create(activitie);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/activity_benefit/{id}")
                .buildAndExpand(activitie.getId()).toUri()).build();
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<ActivityBenefit> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityBenefitApplication.findById(id));
    }

    @RequestMapping(path = "/source/{source}")
    public ResponseEntity<ActivityBenefit> findBySource(@PathVariable("source") int source) {
        log.debug("source : {source}", source);
        return ResponseEntity.ok(activityBenefitApplication.findBySource(source));
    }
}