package com.jxmall.activity.channel.adapter.api;

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

import com.jxmall.activity.channel.application.ActivityChannelApplication;
import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

@RestController
@RequestMapping("/activity_channels")
public class ActivityChannelController {

    @Autowired
    private ActivityChannelApplication activityChannelApplication;

    @GetMapping
    public ResponseEntity<List<ActivityChannel>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityChannelApplication.search(key));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ActivityChannel activitieChannel, UriComponentsBuilder builder) {
        activityChannelApplication.create(activitieChannel);
        return ResponseEntity.created(builder.path("/activity_channels/{id}").buildAndExpand(activitieChannel.getId()).toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityChannel> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityChannelApplication.findById(id));
    }
}