package com.jxmall.activitie.domain.aggregate.activitie;

import java.util.List;
import java.util.UUID;

import com.jxmall.activitie.domain.aggregate.activitie.root.Activitie;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitieService {

	@Autowired
	private ActivitieRepository repository;

	public List<Activitie> search(String key) {
		return repository.search(key);
	}

	public void create(Activitie activitie) {
		activitie.setId(UUID.randomUUID().toString());
		repository.create(activitie);
	}

	public Activitie findById(String id){
		if(Strings.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}