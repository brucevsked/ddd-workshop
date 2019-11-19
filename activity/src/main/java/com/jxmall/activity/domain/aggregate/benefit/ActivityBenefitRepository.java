package com.jxmall.activity.domain.aggregate.benefit;

import java.util.List;

import com.jxmall.activity.domain.aggregate.benefit.root.ActivityBenefit;

public interface ActivityBenefitRepository {

	ActivityBenefit findBySource(int source);
}
