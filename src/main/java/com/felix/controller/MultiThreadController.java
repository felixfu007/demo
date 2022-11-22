package com.felix.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felix.service.MultiThreadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "", description = "")
@RestController
@RequiredArgsConstructor
public class MultiThreadController {
	
	private final MultiThreadService multiThreadService;
	
	@Operation(summary = "", description = "")
    @PostMapping("/unlockThread")
	public String unlockThread() {
		return multiThreadService.test();
	}
}
