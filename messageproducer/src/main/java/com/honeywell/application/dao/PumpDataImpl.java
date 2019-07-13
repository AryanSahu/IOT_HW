package com.honeywell.application.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.honeywell.application.TimeSeriesRecord;



@Repository
public class PumpDataImpl implements PumpDao{

	@Autowired
	EntityManager entitymanager;
	
	static HashMap<String,ArrayList<TimeSeriesRecord>> cache=new HashMap<String, ArrayList<TimeSeriesRecord>>();
	
	static
	{
		
		ArrayList<TimeSeriesRecord> list=new ArrayList<TimeSeriesRecord>();
		TimeSeriesRecord t1=new TimeSeriesRecord();
		t1.setData(70);
		list.add(t1);
		
		t1=new TimeSeriesRecord();
		t1.setData(80);
		list.add(t1);
		
		t1=new TimeSeriesRecord();
		t1.setData(85);
		list.add(t1);
		
		t1=new TimeSeriesRecord();
		t1.setData(90);
		list.add(t1);
		
		
		t1=new TimeSeriesRecord();
		t1.setData(100);
		list.add(t1);
		
		
		t1=new TimeSeriesRecord();
		t1.setData(180);
		list.add(t1);
		
		t1=new TimeSeriesRecord();
		t1.setData(90);
		list.add(t1);
		t1=new TimeSeriesRecord();
		t1.setData(180);
		list.add(t1);
		
		
		
		cache.put("saturday", list);
		
	}
	
	
	

	@Override
	public void pumpData(TimeSeriesRecord timeSeriesRecord) {
		// TODO Auto-generated method stub
		
		ArrayList<TimeSeriesRecord> list=cache.get("saturday");
		list.add(timeSeriesRecord);
		cache.put("saturday",list);
	}




	@Override
	public List<Integer> getAllData(String day) {
		
		ArrayList<TimeSeriesRecord> list=cache.get(day);
      		List<Integer> data=new ArrayList<>();
		
		for(TimeSeriesRecord record:list)
		{
			
			data.add(record.getData());
		}
		
		return data;
		
		
	}

}
