package com.jxmall.user.domain.aggregate.activity.root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {
    private String id;

    private String userId;

    private String name;

    private String content;

    private String address;

    private String[] labels;
}
