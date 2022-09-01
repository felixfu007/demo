package com.felix.controller;

import com.felix.demo.FibonacciTask;
import com.felix.service.AtomicIntegerService;
import com.felix.service.CountDownService;
import com.felix.service.CyclicBarrierService;
import com.felix.service.FibonacciTaskService;
import com.felix.service.LockService;
import com.felix.service.SynchronizedService;
import com.felix.service.WaitNotifyService;
import com.felix.service.ThreadService;
import com.felix.service.YieldJoinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "", description = "")
@RestController
@RequiredArgsConstructor
public class DemoController {
    private final ThreadService threadService;
    private final SynchronizedService runnableService;
    private final WaitNotifyService waitNotifyService;
    private final SynchronizedService synchronizedService;
    private final AtomicIntegerService atomicIntegerService;
    private final LockService lockService;
    private final YieldJoinService yieldJoinService;
    private final CountDownService countDownService;
    private final CyclicBarrierService cyclicBarrierService;
    private final FibonacciTaskService fibonacciTaskService;

    /**
     *  程式要執行多工要覆蓋run()
     *  Bad!!->類別不能在使用繼承
     *  工人"各"搬50塊(產生多工問題)!!!
     */
    @Operation(summary = "", description = "")
    @PostMapping("/thread")
    public String demoThread() {
        threadService.demo();
        return "success";
    }

    /**
     *  程式要執行多工要實作Runnable
     *  Better!!
     *  工人"各"般50塊
     */
    @Operation(summary = "", description = "")
    @PostMapping("/runnable")
    public String demoRunnable() {
        runnableService.demo();
        return "success";
    }

    /**
     *  wait(),notify()的使用(規定要做完某些是下一個程式才能執行)
     *  synchronized
     */
    @Operation(summary = "", description = "")
    @PostMapping("/wait_notify")
    public String demoWaitNotify() {
        waitNotifyService.demo();
        return "success";
    }

    //synchronized的應用
    @Operation(summary = "", description = "")
    @PostMapping("/synchronized")
    public String demoSynchronized() {
        synchronizedService.demo();
        return "success";
    }

    //用AtomicInteger將i++改為一個步驟完成
    @Operation(summary = "", description = "")
    @PostMapping("/atomicInteger")
    public String demoAtomicInteger() {
        atomicIntegerService.demo();
        return "success";
    }

    //將synchronized改成lock的寫法
    @Operation(summary = "", description = "")
    @PostMapping("/lock")
    public String demoLock() {
        lockService.demo();
        return "success";
    }

    //yield & join
    @Operation(summary = "", description = "")
    @PostMapping("/yieldJoin")
    public String demoYieldJoin() {
        yieldJoinService.demo();
        return "success";
    }

    //每執行一次countDown()-> new CountDownLatch(3)會-1(到0時await();才會繼續往下執行)
    @Operation(summary = "", description = "")
    @PostMapping("/countdown")
    public String demoCountDown() {
        countDownService.demo();
        return "success";
    }

    //每執行一次countDown()-> new CountDownLatch(3)會-1(到0時await();才會繼續往下執行)
    @Operation(summary = "", description = "")
    @PostMapping("/cyclicBarrier")
    public String cyclicBarrier() {
        cyclicBarrierService.demo();
        return "success";
    }

    @Operation(summary = "", description = "")
    @PostMapping("/fibonacciTask")
    public String fibonacciTask() {
        fibonacciTaskService.demo();
        return "success";
    }
}
