package com.shiju.sample.disruptor.event;

import com.lmax.disruptor.EventHandler;

public class ProcessEventHandler implements EventHandler<ProcessEvent>{

	public void onEvent(ProcessEvent arg0, long sequence, boolean endOfBatch) throws Exception {
		
		
	}

}
