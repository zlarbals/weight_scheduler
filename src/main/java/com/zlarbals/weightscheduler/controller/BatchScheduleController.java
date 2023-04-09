package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchScheduleController {

    private final CalenderService calenderService;

    @GetMapping("/calender/create/{year}")
    public void createCalenderByYear(@PathVariable int year){
        calenderService.createCalenderByYear(year);
    }

}
