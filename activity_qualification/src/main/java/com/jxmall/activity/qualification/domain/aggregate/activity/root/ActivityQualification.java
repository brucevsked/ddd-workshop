package com.jxmall.activity.qualification.domain.aggregate.activity.root;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityQualification {
    private String id;

    private String name;

    private String email;

    private String address;

    private int age;

    private String[] labels;
}
