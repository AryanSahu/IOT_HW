package com.honeywell.application;

public class TimeSeriesRecord {
	
	
	private Long id;
	private String deviceId;
	private int data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	@Override
	public String toString() {
		return "TimeSeriesRecord [id=" + id + ", deviceId=" + deviceId + ", data=" + data + "]";
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

}


	