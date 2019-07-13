package com.honeywell.application.dao;

import java.sql.Date;
import java.util.List;

import com.honeywell.application.TimeSeriesRecord;

public interface PumpDao {
	
	void pumpData(TimeSeriesRecord timeSeriesRecord);

	List<Integer> getAllData(String day);
	
	

}
