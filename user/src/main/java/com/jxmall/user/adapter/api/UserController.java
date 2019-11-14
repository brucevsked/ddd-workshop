package com.jxmall.user.adapter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import com.jxmall.user.domain.aggregate.user.UserServices;
import com.jxmall.user.domain.aggregate.user.root.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> search(@RequestParam("key") String key) {
        List<User> userList = userServices.search(key);
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user, UriComponentsBuilder builder) {
        user.setId(UUID.randomUUID().toString());
        return ResponseEntity.created(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> load(@PathParam("id") String id) {
        System.out.println("id : " + id);
        return ResponseEntity.ok(new User());
    }
}