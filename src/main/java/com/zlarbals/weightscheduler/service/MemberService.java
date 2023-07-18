package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.dto.MemberSyncResponseDto;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import com.zlarbals.weightscheduler.service.retrofit.RetrofitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final RetrofitService retrofitService;

    private final MemberRepository memberRepository;

    public void syncMember(){
        log.info("###### syncMember start");

        List<MemberSyncResponseDto> memberSyncResponseDtoList = retrofitService.sendMemberSyncApi();
        memberSyncResponseDtoList.stream().filter((memberDto -> !memberRepository.existsById(memberDto.getSeq())))
                .forEach(memberDto -> {
                    Member newMember = Member.builder()
                            .seq(memberDto.getSeq())
                            .email(memberDto.getEmail())
                            .build();

                    memberRepository.save(newMember);
                });

        log.info("###### syncMember end");
    }

}
