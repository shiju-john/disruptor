package com.shiju.sample.disruptor.event.producer;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;
import com.shiju.sample.disruptor.event.ProcessEvent;


public class ProcessEventProducer {
	
	private final RingBuffer<ProcessEvent> ringBuffer;
	
	public ProcessEventProducer(RingBuffer<ProcessEvent> ringBuffer){
		this.ringBuffer = ringBuffer;
		
	}
	
	public void onData(ByteBuffer buffer ){
		long sequence = ringBuffer.next();
		ProcessEvent event = ringBuffer.get(sequence);
		event.setEventName("TestEvent1");
		ringBuffer.publish(sequence);
		
	}

}
