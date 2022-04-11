package com.mob.restfulService.controllers;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mob.restfulService.ppt.PPTFileMerger;

@RequestMapping("/")
@RestController
public class EventDataProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(EventDataProcessor.class);
	
	
	/**
	 * Create new event root
	 * 
	 * @param event
	 * @return
	 */
	@PostMapping(value="/api/ppt/merge", consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Object> postRootEvent(@RequestBody String event) {		
		String result = "";
		logger.info("Event from the ROOT API {}  ", event);
		JSONObject jsonObject = new JSONObject(event);
				
		PPTFileMerger merger=new PPTFileMerger();
		
		result = merger.merge(jsonObject);
		
		
		if(result.contains("Error") || result.contains("error"))  
			result = "{'status':'error','errorMessage':'"+result+"'}";
		else
			result = "{'status':'success'}";
		
		logger.info(" Responce from EventDataProcessor.postRootEvent is - {} ", result);
		
		return new ResponseEntity<Object>((new JSONObject(result)).toString(),HttpStatus.OK);//new ResponseEntity<Object>(, HttpStatus.OK);
	}
	
	
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {

//		CheckConnectionDao checkConDao = new CheckConnectionDao();
//		try {
//			checkConDao.checkConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//DBConnection.isValid();
		logger.info("Health check: health");

		return new ResponseEntity<>("Event from Docker Image: "+"Healthy", HttpStatus.OK);
	}	
}
