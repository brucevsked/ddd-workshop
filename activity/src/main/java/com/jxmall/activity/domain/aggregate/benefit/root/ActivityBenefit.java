package com.jxmall.activity.domain.aggregate.benefit.root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityBenefit {
    private String id;

    private int source;

    private int money;
}
