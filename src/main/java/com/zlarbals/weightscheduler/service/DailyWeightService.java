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
        LocalDate firstDateByMonth = date.withDayOfMonth(1);
        LocalDate lastDateByMonth = date.withDayOfMonth(date.lengthOfMonth());

        memberList.stream().forEach(member -> {
            for (LocalDate iterDate = firstDateByMonth; iterDate.isBefore(lastDateByMonth) || iterDate.isEqual(lastDateByMonth);iterDate = iterDate.plusDays(1)){
                DailyWeight dailyWeight = DailyWeight.builder()
                        .member(member)
                        .date(iterDate)
                        .weight(null)
                        .build();

                dailyWeightRepository.save(dailyWeight);
            }
        });
    }
}
