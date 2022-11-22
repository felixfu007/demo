package com.felix.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MultiThreadService {
	public String test() {
		
		
		return "done";
	}
}
