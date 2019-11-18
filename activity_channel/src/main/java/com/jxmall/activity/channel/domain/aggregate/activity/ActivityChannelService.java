package com.jxmall.activity.channel.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityChannelService {

	@Autowired
	private ActivityChannelRepository repository;

	public List<ActivityChannel> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityChannel activityChannel) {
		activityChannel.setId(UUID.randomUUID().toString());
		repository.create(activityChannel);
	}

	public ActivityChannel findById(String id){
		if(Strings.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}