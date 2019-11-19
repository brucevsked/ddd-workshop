package com.jxmall.activitie.adapter.api;

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

import com.jxmall.activitie.application.ActivitieApplication;
import com.jxmall.activitie.domain.aggregate.activitie.ActivitieService;
import com.jxmall.activitie.domain.aggregate.activitie.root.Activitie;

@RestController
@RequestMapping("/activities")
public class ActivitieController {

    @Autowired
    private ActivitieApplication activitieApplication;

    @GetMapping
    public ResponseEntity<List<Activitie>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activitieApplication.search(key));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Activitie activitie, UriComponentsBuilder builder) {
        activitieApplication.create(activitie);
        return ResponseEntity.created(builder.path("/activities/{id}").buildAndExpand(activitie.getId()).toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activitie> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activitieApplication.findById(id));
    }
}