package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.DailyWeight;
import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.repository.DailyWeightRepository;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailyWeightService {

    private final DailyWeightRepository dailyWeightRepository;

    private final MemberRepository memberRepository;

    public void createDailyWeight(LocalDate date, Long memberSeq) {
        List<Member> memberList;
        if(ObjectUtils.isEmpty(memberSeq)){
            memberList = memberRepository.findAll();
        }else{
            memberList = List.of(memberRepository.findById(memberSeq).orElseThrow(()->new IllegalArgumentException("존재하지 않는 member 입니다.")));
        }
        LocalDate firstDateOfMonth = date.withDayOfMonth(1);
        LocalDate lastDateOfMonth = date.withDayOfMonth(date.lengthOfMonth());

        List<LocalDate> standardLocalDateListOfYearAndMonth = new ArrayList<>();
        for(LocalDate currentDate = firstDateOfMonth; !currentDate.isAfter(lastDateOfMonth); currentDate = currentDate.plusDays(1)){
            standardLocalDateListOfYearAndMonth.add(currentDate);
        }

        memberList.forEach(member -> {
            List<DailyWeight> existingDailyWeightList = dailyWeightRepository.findDailyWeightsByMemberAndDateIn(member, standardLocalDateListOfYearAndMonth);
            Set<LocalDate> existingLocalDateList = existingDailyWeightList.stream().map(DailyWeight::getDate).collect(Collectors.toSet());

            List<DailyWeight> dailyWeightListToSave = standardLocalDateListOfYearAndMonth.stream()
                    .filter(standardLocalDate -> !existingLocalDateList.contains(standardLocalDate))
                    .map(standardLocalDate -> DailyWeight.builder().member(member).date(standardLocalDate).build())
                    .collect(Collectors.toList());

            dailyWeightRepository.saveAll(dailyWeightListToSave);
        });
    }
}
