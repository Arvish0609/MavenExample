package com.cg.entity;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.service.TrainerService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class DemoDataEntry {
	@Autowired
	private TrainerService service;

	@EventListener
	public void onAppReady(ApplicationReadyEvent event) {
		if (service.findall().size() == 0) {
			try {
				ObjectMapper mapper = new ObjectMapper();

				Trainer[] trainers = mapper.readValue(getClass().getClassLoader().getResource("trainers.json"),
						Trainer[].class);

				for (Trainer trainer : trainers) {
					service.addtrainer(trainer);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
