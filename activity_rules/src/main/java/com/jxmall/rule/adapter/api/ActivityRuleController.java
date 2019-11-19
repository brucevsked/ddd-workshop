package com.jxmall.rule.adapter.api;

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

import com.jxmall.rule.application.ActivityRuleApplication;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

@RestController
@RequestMapping("/jxmall/activity_rules")
public class ActivityRuleController {

    @Autowired
    private ActivityRuleApplication activityRuleApplication;

    @GetMapping
    public ResponseEntity<List<ActivityRule>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityRuleApplication.search(key));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ActivityRule rule, UriComponentsBuilder builder) {
        activityRuleApplication.create(rule);
        return ResponseEntity.created(builder.path("/activity_rules/{id}").buildAndExpand(rule.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityRule> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityRuleApplication.findById(id));
    }
}