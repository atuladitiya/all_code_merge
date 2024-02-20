package com.minutes.microservices.camelmicroservicea.routes.a;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyFirstTimerRouter extends RouteBuilder {
public class SimpleLoggingProcessor implements Processor {

		@Override
		public void process(Exchange exchange) throws Exception {
			// TODO Auto-generated method stub

		}

	}
@Autowired
private GetCurrentTimeBean getCurrentTimeBean;
@Autowired
private SimpleLoggingProcessingComponent loggingComponent;
	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
		.log("${body}")
//		.transform().constant("Time now is"+LocalDateTime.now())
		.bean(getCurrentTimeBean)
		.log("${body}")
		.bean(loggingComponent)
		.process(new SimpleLoggingProcessor())
		.to("log:first-timer");
		
		
	}

}
@Component
class GetCurrentTimeBean{
	public String getCurrentTime() {
		return "time now is" +LocalDateTime.now(); 
	}
}
@Component
class SimpleLoggingProcessingComponent{
	private Logger logger=LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	public void process(String message) {
		logger.info("SimpleLoggingProcessingComponent {}",message);
		
	}
}
@Component
class SimpleLoggingProcessor implements Processor{
	private Logger logger=LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		
			logger.info("SimpleLoggingProcessingComponent {}",exchange.getMessage().getBody());
			
		}
		
	}
	
