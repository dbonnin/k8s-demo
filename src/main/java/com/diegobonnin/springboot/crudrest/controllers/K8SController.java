package com.diegobonnin.springboot.crudrest.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@NoArgsConstructor
@RestController
@RequestMapping("/api/k8s-test")
public class K8SController {

	@Value("${appVersion}")
	private String appVersion;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@GetMapping(produces = "application/json")
	public Mono<ResponseEntity<PodData>> getTest() {

		log.info("getTest()");

		// Get hostname using standard java library
		String hostname = null;
		String ip = null;
		
		try {
			hostname = java.net.InetAddress.getLocalHost().getHostName();
			ip = java.net.InetAddress.getLocalHost().getHostAddress();
		} catch (java.net.UnknownHostException e) {
			hostname = "unknown";
			ip = "unknown";
		}

		
		return Mono.just(ResponseEntity.ok(PodData.builder()
				.ip(ip)
				.hostname(hostname)
				.appVersion(appVersion)
				.timestamp(sdf.format(new Date()))
				.build()));
		
	}

}
