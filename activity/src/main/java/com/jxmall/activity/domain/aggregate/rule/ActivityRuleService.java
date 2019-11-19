package com.jxmall.activity.domain.aggregate.rule;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.domain.aggregate.rule.root.ActivityRule;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRuleService{

    @Autowired
    private ActivityRuleRepository repository;

	public ActivityRule findByMonth(int month) {
		return repository.findByMonth(month);
	}
}