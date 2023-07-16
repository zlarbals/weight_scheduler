package com.zlarbals.weightscheduler.schedule;

import com.zlarbals.weightscheduler.service.CalenderService;
import com.zlarbals.weightscheduler.service.DailyWeightService;
import com.zlarbals.weightscheduler.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class BatchScheduler {

    private final CalenderService calenderService;

    private final DailyWeightService dailyWeightService;

    private final MemberService memberService;

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

    /**
     * 매달 20일 새벽 4시
     * 등록된 모든 유저의 다음달 DailyWeight 생성.
     */
    @Scheduled(cron = "0 0 4 20 * *")
    public void createNextMonthDailyWeight(){
        LocalDate nextMonthDate = LocalDate.now().plusMonths(1);
        dailyWeightService.createDailyWeight(nextMonthDate);
    }

    /**
     * 매일 새벽 3시
     * 통합게정 사용자 동기화
     */
    @Scheduled(cron = "0 0 3 * * *")
    public void syncMember(){
        memberService.syncMember();
    }

}
