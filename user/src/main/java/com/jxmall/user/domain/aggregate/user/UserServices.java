package com.jxmall.user.domain.aggregate.user;

import java.util.List;

import com.jxmall.user.domain.aggregate.user.root.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices{

    @Autowired
    private UserRepository repository;

	public List<User> search(String key) {
		return repository.search(key);
	}
}