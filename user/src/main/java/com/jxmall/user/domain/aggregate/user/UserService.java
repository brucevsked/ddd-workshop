package com.jxmall.user.domain.aggregate.user;

import java.util.List;
import java.util.UUID;

import com.jxmall.user.domain.aggregate.event.UserCreated;
import com.jxmall.user.domain.aggregate.user.root.User;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ApplicationContext applicationContext;

	public List<User> search(String key) {
		return repository.search(key);
	}

	public void create(User user) {
		// 1、生成UserId
		user.setId(UUID.randomUUID().toString());

		// 2、持久化Repository
		repository.create(user);

		// 2、添加活动
		applicationContext.publishEvent(new UserCreated(this, user.getId()));
	}

	public User findById(String id) {
		if (Strings.isEmpty(id)) {
			return null;
		}
		return repository.findById(id);
	}
}