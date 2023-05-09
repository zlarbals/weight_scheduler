package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.DailyWeight;
import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.repository.DailyWeightRepository;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyWeightService {

    private final DailyWeightRepository dailyWeightRepository;

    private final MemberRepository memberRepository;

    public void createDailyWeight(LocalDate date) {
        List<Member> memberList = memberRepository.findAll();
        LocalDate firstDateOfMonth = date.withDayOfMonth(1);
        LocalDate lastDateOfMonth = date.withDayOfMonth(date.lengthOfMonth());

        memberList.forEach(member -> {
            for (LocalDate currentDate = firstDateOfMonth; currentDate.isBefore(lastDateOfMonth) || currentDate.isEqual(lastDateOfMonth);currentDate = currentDate.plusDays(1)){
                DailyWeight dailyWeight = DailyWeight.builder()
                        .member(member)
                        .date(currentDate)
                        .build();

                dailyWeightRepository.save(dailyWeight);
            }
        });
    }
}
