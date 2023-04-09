package com.zlarbals.weightscheduler.schedule;

import com.zlarbals.weightscheduler.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CalenderScheduler {

    private final CalenderService calenderService;

    /**
     * 매년 12월 20일 새벽 2시
     * 내년 연단위 캘린더 생성
     */
    @Scheduled(cron = "${scheduler.batch-time.create-calender}")
    public void createCalenderByNextYear(){
        try{
            LocalDate nextYearDate = LocalDate.now().plusYears(1);
            calenderService.createCalenderByYear(nextYearDate.getYear());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
