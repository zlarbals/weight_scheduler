package com.zlarbals.weightscheduler.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "WS_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "memNo",callSuper = true)
@Getter
public class Member extends BaseTimeEntity{

    @Id
    @Column(name = "MEMBER_NO")
    private String memNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name="NICKNAME")
    private String nickname;

}
