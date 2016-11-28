package com.shiju.sample.disruptor.event;

public class ProcessEvent {
	
	private String eventName;
	
	/**
	 * 
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}
	
	
	/**
	 * 
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
