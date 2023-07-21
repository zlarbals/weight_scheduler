package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.DailyWeight;
import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.repository.DailyWeightRepository;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("local")
class DailyWeightServiceTest {

    @Autowired
    private DailyWeightService dailyWeightService;

    @Autowired
    private DailyWeightRepository dailyWeightRepository;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원 DailyWeight 생성(전체 회원)")
    @Test
    public void testCreateDailyWeightAllMember(){
        //case
        Member member1 = Member.builder()
                .email("1234@gmail.com")
                .seq(1L)
                .build();

        Member member2 = Member.builder()
                .email("1234@gmail.com")
                .seq(2L)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        LocalDate targetLocalDate = LocalDate.of(2023,7,1);

        //when
        dailyWeightService.createDailyWeight(targetLocalDate,null);

        //then
        int expectedDateCount = targetLocalDate.lengthOfMonth() * 2;
        int createdDateCount = dailyWeightRepository.findAll().size();
        assertEquals(expectedDateCount,createdDateCount);
    }

    @DisplayName("회원 DailyWeight 생성(전체 회원) - dailyWeight 중복 값 존재")
    @Test
    public void testCreateDailyWeightAllMemberWithDuplicateDailyWeight(){
        //case
        Member member1 = Member.builder()
                .email("1234@gmail.com")
                .seq(1L)
                .build();

        Member member2 = Member.builder()
                .email("1234@gmail.com")
                .seq(2L)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        LocalDate targetLocalDate = LocalDate.of(2023,7,1);
        DailyWeight dailyWeight = DailyWeight.builder()
                .date(targetLocalDate)
                .member(member1)
                .build();

        dailyWeightRepository.save(dailyWeight);

        //when
        dailyWeightService.createDailyWeight(targetLocalDate,null);

        //then
        int expectedDateCount = targetLocalDate.lengthOfMonth() * 2;
        int createdDateCount = dailyWeightRepository.findAll().size();
        assertEquals(expectedDateCount,createdDateCount);
    }

    @DisplayName("회원 DailyWeight 생성(회원 1명지정)")
    @Test
    public void testCreateDailyWeightOneMember(){
        //case
        Member member1 = Member.builder()
                .email("1234@gmail.com")
                .seq(1L)
                .build();

        Member member2 = Member.builder()
                .email("1234@gmail.com")
                .seq(2L)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        LocalDate targetLocalDate = LocalDate.of(2023,7,1);

        //when
        dailyWeightService.createDailyWeight(targetLocalDate,1L);

        //then
        int expectedDateCount = targetLocalDate.lengthOfMonth();
        int createdDateCount = dailyWeightRepository.findAll().size();
        assertEquals(expectedDateCount,createdDateCount);
    }

    @DisplayName("회원 DailyWeight 생성(회원 1명지정) - dailyWeight 중복 값 존재")
    @Test
    public void testCreateDailyWeightOneMemberWithDuplicateDailyWeight(){
        //case
        Member member1 = Member.builder()
                .email("1234@gmail.com")
                .seq(1L)
                .build();

        Member member2 = Member.builder()
                .email("1234@gmail.com")
                .seq(2L)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        LocalDate targetLocalDate = LocalDate.of(2023,7,1);
        DailyWeight dailyWeight = DailyWeight.builder()
                .date(targetLocalDate)
                .member(member1)
                .build();

        dailyWeightRepository.save(dailyWeight);

        //when
        dailyWeightService.createDailyWeight(targetLocalDate,1L);

        //then
        int expectedDateCount = targetLocalDate.lengthOfMonth();
        int createdDateCount = dailyWeightRepository.findAll().size();
        assertEquals(expectedDateCount,createdDateCount);
    }

}