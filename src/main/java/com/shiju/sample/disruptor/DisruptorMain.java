package com.shiju.sample.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.shiju.sample.disruptor.event.ProcessEvent;
import com.shiju.sample.disruptor.event.ProcessEventFactory;
import com.shiju.sample.disruptor.event.ProcessEventHandler;
import com.shiju.sample.disruptor.event.producer.ProcessEventProducer;

public class DisruptorMain {
	
	public static void main(String[] args) throws InterruptedException {
		 int bufferSize = 1024;
		 Executor executor = Executors.newCachedThreadPool();
		 ProcessEventFactory factory = new ProcessEventFactory();
		 Disruptor<ProcessEvent> disruptor = new Disruptor<ProcessEvent>(factory, bufferSize, executor);
		 disruptor.handleEventsWith(new ProcessEventHandler<ProcessEvent>());
		 disruptor.start();
		 
		 RingBuffer<ProcessEvent> ringBuffer = disruptor.getRingBuffer();
		 ProcessEventProducer eventProducer = new ProcessEventProducer(ringBuffer);
	     ByteBuffer  buffer = ByteBuffer.allocate(8);
	        for (long l = 0; true; l++)
	        {
	        	buffer.putLong(0, l);
	            eventProducer.onData(buffer);
	            Thread.sleep(1000);
	        }
	}

}
