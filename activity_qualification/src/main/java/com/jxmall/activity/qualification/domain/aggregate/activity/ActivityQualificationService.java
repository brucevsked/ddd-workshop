package com.jxmall.activity.qualification.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityQualificationService {

	@Autowired
	private ActivityQualificationRepository repository;

	public List<ActivityQualification> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityQualification activityQualification) {
		activityQualification.setId(UUID.randomUUID().toString());
		repository.create(activityQualification);
	}

	public ActivityQualification findById(String id){
		if(Strings.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}