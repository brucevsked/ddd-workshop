package com.jxmall.activitie.application;

import java.util.List;

import com.jxmall.activitie.domain.aggregate.activitie.ActivitieService;
import com.jxmall.activitie.domain.aggregate.activitie.root.Activitie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivitieApplication {

    @Autowired
    private ActivitieService activitieService;

    public List<Activitie> search(String key) {
        return activitieService.search(key);
    }

    public void create(Activitie activitie) {
        activitieService.create(activitie);
    }

    public Activitie findById(String id) {
        return activitieService.findById(id);
    }
}