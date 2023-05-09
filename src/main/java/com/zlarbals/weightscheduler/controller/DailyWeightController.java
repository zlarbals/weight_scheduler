package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.service.DailyWeightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/dailyweight")
@RequiredArgsConstructor
public class DailyWeightController {

    private final DailyWeightService dailyWeightService;

    @PostMapping("")
    public void createNextMonthDailyWeight(@RequestParam int year,@RequestParam int month){
        LocalDate targetDate = LocalDate.of(year,month,1);
        dailyWeightService.createDailyWeight(targetDate);
    }

}
