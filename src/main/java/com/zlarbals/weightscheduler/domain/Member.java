package com.zlarbals.weightscheduler.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "WS_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "seq",callSuper = true)
@Getter
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity{

    @Id
    @Column(name = "MEMBER_SEQ")
    private Long seq;

    @Column(name = "EMAIL")
    private String email;

    @Column(name="NICKNAME")
    private String nickname;

}
