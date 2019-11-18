package com.jxmall.rule.domain.aggregate.rule;

import java.util.List;
import java.util.UUID;

import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRuleService{

    @Autowired
    private ActivityRuleRepository repository;

	public List<ActivityRule> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityRule ActivityRule) {
		ActivityRule.setId(UUID.randomUUID().toString());
		repository.create(ActivityRule);
	}

	public ActivityRule findById(String id) {
		if(Strings.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}