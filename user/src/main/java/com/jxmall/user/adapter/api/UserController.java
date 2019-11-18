package com.jxmall.user.adapter.api;

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

import com.jxmall.user.domain.aggregate.user.UserService;
import com.jxmall.user.domain.aggregate.user.root.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(userService.search(key));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user, UriComponentsBuilder builder) {
        userService.create(user);
        return ResponseEntity.created(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}