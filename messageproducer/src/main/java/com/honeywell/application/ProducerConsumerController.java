package com.honeywell.application;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.application.service.PumpingService;

@RestController


public class ProducerConsumerController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProducerConsumerController.class);
	
	@Autowired
	PumpingService service;

   

	@RequestMapping("/pumpTimeSeriesData")
	    public void send(String deviceId,String data){
		
		TimeSeriesRecord record=new TimeSeriesRecord();
		int  timeSeries=Integer.parseInt(data);
		record.setData(timeSeries);
		record.setDeviceId(deviceId);
		record.setId(4l);
		
		System.out.println(record);
		
		service.pumpData(record);
       
    }
	
	@RequestMapping("/getTimeSeriesData")
    public List<Integer> send(String day){
	
	  List<Integer> resultList=service.getData(day);
	  
	  return resultList;
   
}

	
	

}
