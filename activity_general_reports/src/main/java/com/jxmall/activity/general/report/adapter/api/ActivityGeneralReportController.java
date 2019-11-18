package com.jxmall.activity.general.report.adapter.api;

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

import com.jxmall.activity.general.report.domain.aggregate.activity.ActivityGeneralReportService;
import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

@RestController
@RequestMapping("/activity_general_reports")
public class ActivityGeneralReportController {

    @Autowired
    private ActivityGeneralReportService activityGeneralReportService;

    @GetMapping
    public ResponseEntity<List<ActivityGeneralReport>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityGeneralReportService.search(key));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ActivityGeneralReport activitieGeneralReport, UriComponentsBuilder builder) {
        activityGeneralReportService.create(activitieGeneralReport);
        return ResponseEntity.created(builder.path("/activity_general_reports/{id}").buildAndExpand(activitieGeneralReport.getId()).toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityGeneralReport> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityGeneralReportService.findById(id));
    }
}