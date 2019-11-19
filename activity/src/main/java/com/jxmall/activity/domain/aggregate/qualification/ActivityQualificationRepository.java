package com.jxmall.activity.domain.aggregate.qualification;

import com.jxmall.activity.domain.aggregate.qualification.root.ActivityQualification;

public interface ActivityQualificationRepository {
    
    ActivityQualification getCurrentActivityQualification();
}
