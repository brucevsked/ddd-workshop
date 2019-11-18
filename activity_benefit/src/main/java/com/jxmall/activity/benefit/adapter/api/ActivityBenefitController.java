package com.jxmall.activity.benefit.adapter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import com.jxmall.activity.benefit.domain.aggregate.activity.ActivityBenefitService;
import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

@RestController
@RequestMapping("/activity_benefits")
public class ActivityBenefitController {

    @Autowired
    private ActivityBenefitService activityBenefitService;

    @GetMapping
    public ResponseEntity<List<ActivityBenefit>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityBenefitService.search(key));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ActivityBenefit activitie, UriComponentsBuilder builder) {
        activityBenefitService.create(activitie);
        return ResponseEntity.created(builder.path("/activity_benefit/{id}").buildAndExpand(activitie.getId()).toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityBenefit> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityBenefitService.findById(id));
    }
}