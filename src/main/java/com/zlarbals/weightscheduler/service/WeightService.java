package com.zlarbals.weightscheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeightService {


    public void insertWeight(Double weight, LocalDate date){
        //TODO date에 맞는 dailyWeight가져오기

        //TODO date에 맞는 dailyWeigth 없으면 결재 등급에 따라서 dailyWeight생성.

        //TODO date파라미터에 맞는 dailyWeight에 weight값 넣기
    }

}
