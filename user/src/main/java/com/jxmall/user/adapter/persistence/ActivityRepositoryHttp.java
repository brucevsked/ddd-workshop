package com.jxmall.user.adapter.persistence;

import java.net.URI;

import com.jxmall.user.domain.aggregate.activity.ActivityRepository;
import com.jxmall.user.domain.aggregate.activity.root.Activity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ActivityRepositoryHttp implements ActivityRepository {

    private RestTemplate client = new RestTemplate();

    @Value("${activity.server.api.create}")
    private String createApi;

    @Override
    public void create(Activity activity) {

        URI uri = client.postForLocation(createApi, activity);

        // 暂时不处理返回的URI
        log.info("{}://{}:{}{}", uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath());
    }
}