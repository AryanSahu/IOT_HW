package com.honeywell.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.application.TimeSeriesRecord;
import com.honeywell.application.dao.PumpDao;

@Service
public class PumpingService {
	
	@Autowired
	PumpDao pumpDao;
	
	public void pumpData(TimeSeriesRecord timeSeriesRecord)
	{
		pumpDao.pumpData(timeSeriesRecord);
	}
	
	public List<Integer> getData(String day)
	{
		
		return pumpDao.getAllData(day);
	}

}
