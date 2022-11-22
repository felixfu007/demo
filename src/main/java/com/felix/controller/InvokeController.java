package com.felix.controller;

import com.felix.service.InvokeTestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationTargetException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "", description = "")
@RestController
@RequiredArgsConstructor
public class InvokeController {
    private final InvokeTestService invokeTestService;

    /**
     *  程式要執行多工要覆蓋run()
     *  Bad!!->類別不能在使用繼承
     *  工人"各"搬50塊(產生多工問題)!!!
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws ClassNotFoundException 
     */
    @Operation(summary = "", description = "")
    @PostMapping("/runInvoke")
    public String runInvoke() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	invokeTestService.runInvoke();
        return "success";
    }
}
