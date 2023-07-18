package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.dto.MemberSyncResponseDto;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import com.zlarbals.weightscheduler.service.retrofit.RetrofitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ActiveProfiles("local")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Mock
    RetrofitService retrofitService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("통합계정 회원 동기화")
    @Test
    public void testSyncMember(){
        //case
        MemberService memberService = new MemberService(retrofitService, memberRepository);
        MemberSyncResponseDto memberSyncResponseDto = new MemberSyncResponseDto(1L,"1234@gmail.com");
        List<MemberSyncResponseDto> memberSyncResponseDtoList = List.of(memberSyncResponseDto);
        when(retrofitService.sendMemberSyncApi()).thenReturn(memberSyncResponseDtoList);

        //when
        memberService.syncMember();

        //then
        List<Member> memberList = memberRepository.findAll();
        assertEquals(1,memberList.size());
        assertEquals("1234@gmail.com",memberList.get(0).getEmail());
    }

}