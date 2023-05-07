package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.dto.RegisterWeightDto;
import com.zlarbals.weightscheduler.service.DailyWeightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/dailyweight")
@RequiredArgsConstructor
public class DailyWeightController {

    private final DailyWeightService dailyWeightService;

    @GetMapping("/batch/nextmonth")
    public void createNextMonthDailyWeight(){
        LocalDate nextMonthDate = LocalDate.now().plusMonths(1);
        dailyWeightService.createDailyWeight(nextMonthDate);
    }

}
