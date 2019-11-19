package com.jxmall.activity.adapter.persistence;


import com.jxmall.activity.domain.aggregate.benefit.ActivityBenefitRepository;
import com.jxmall.activity.domain.aggregate.benefit.root.ActivityBenefit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ActivityBenefitRepositoryHttp implements ActivityBenefitRepository {
    
    private RestTemplate client = new RestTemplate();

    @Value("${activity.benefit.server.api.source}")
    private String sourceApi;

    public ActivityBenefit findBySource(int source) {
        return client.getForEntity(sourceApi, ActivityBenefit.class, source).getBody();
    }
}