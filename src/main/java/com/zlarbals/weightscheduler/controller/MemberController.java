package com.zlarbals.weightscheduler.controller;

import com.zlarbals.weightscheduler.dto.MemberSignUpDto;
import com.zlarbals.weightscheduler.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

}
