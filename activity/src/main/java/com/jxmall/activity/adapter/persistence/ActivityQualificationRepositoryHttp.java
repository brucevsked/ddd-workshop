package com.jxmall.activity.adapter.persistence;

import com.jxmall.activity.domain.aggregate.qualification.ActivityQualificationRepository;
import com.jxmall.activity.domain.aggregate.qualification.root.ActivityQualification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ActivityQualificationRepositoryHttp implements ActivityQualificationRepository {

    private RestTemplate client = new RestTemplate();

    @Value("${activity.qualification.server.api.current}")
    private String currentQualificationApi;
    
    public ActivityQualification getCurrentActivityQualification() {
        return client.getForEntity(currentQualificationApi, ActivityQualification.class).getBody();
    }
}