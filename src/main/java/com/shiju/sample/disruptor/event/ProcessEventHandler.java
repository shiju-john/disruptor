package com.shiju.sample.disruptor.event;

import com.lmax.disruptor.EventHandler;

public class ProcessEventHandler<T> implements EventHandler<ProcessEvent>{

	public void onEvent(ProcessEvent processEvent, long sequence, boolean endOfBatch) throws Exception {
		
		System.out.println("Event Recevived "+processEvent.getEventName());
	}

}
