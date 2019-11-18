package com.jxmall.activitie.domain.aggregate.activitie.root;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activitie {
    private String id;

    private String name;

    private String content;

    private String address;

    private String[] labels;
}
