package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.dto.RegisterWeightDto;
import com.zlarbals.weightscheduler.service.WeightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeightController {

    private final WeightService weightService;

    @PostMapping
    public void registerWeightByDay(RegisterWeightDto registerWeightDto){
        weightService.insertWeight(registerWeightDto.getWeight(),registerWeightDto.getDate());
    }

}
