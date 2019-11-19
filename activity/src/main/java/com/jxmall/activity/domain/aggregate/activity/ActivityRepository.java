package com.jxmall.activity.domain.aggregate.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activity.domain.aggregate.activity.root.Activity;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

public interface ActivityRepository {

    List<Activity> search(String key);

    void create(Activity activity);

    Activity findById(String id);
}
