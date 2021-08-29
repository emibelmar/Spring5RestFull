package com.ebmdev.users.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EbmdevKafkaListener {

	private static final Logger log = LoggerFactory.getLogger(EbmdevKafkaListener.class);

	@KafkaListener(topics = "ebmdev-topic", groupId = "ebmdevGroup")
	public void listen(String message) {
		log.info("Code to post the message in the audit API = {}", message);
	}
}
