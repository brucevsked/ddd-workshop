package com.jxmall.user.domain.aggregate.user;

import java.util.List;
import java.util.UUID;

import com.jxmall.user.domain.aggregate.user.root.User;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

	public List<User> search(String key) {
		return repository.search(key);
	}

	public void create(User user) {
		user.setId(UUID.randomUUID().toString());
		repository.create(user);
	}

	public User findById(String id) {
		if(Strings.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}