package com.zlarbals.weightscheduler.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WS_DAILY_WEIGHT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "seq",callSuper = true)
public class DailyWeight extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @Column(name = "WEIGHT_DAY")
    private LocalDate date;

    @Column(name = "WEIGHT_VALUE")
    private float weight;

}
