package com.shiju.sample.disruptor.event;

import com.lmax.disruptor.EventFactory;

public class ProcessEventFactory implements EventFactory<ProcessEvent>{

	public ProcessEvent newInstance() {
		return new ProcessEvent();
	}

}
