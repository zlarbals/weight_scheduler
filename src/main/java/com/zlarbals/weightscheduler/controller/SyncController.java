package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SyncController {

    private final MemberService memberService;

    @GetMapping("/sync/member")
    public void syncMember(){
        memberService.syncMember();
    }

}
