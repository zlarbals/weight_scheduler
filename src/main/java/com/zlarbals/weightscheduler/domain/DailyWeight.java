package com.zlarbals.weightscheduler.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WS_DAILY_WEIGHT",
uniqueConstraints = {
        @UniqueConstraint(
                name = "MEMBER_NO_DATE_UNIQUE",
                columnNames = {"MEMBER_NO","WEIGHT_DAY"}

        )
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "seq",callSuper = true)
@Getter
@Builder
@AllArgsConstructor
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
    private Float weight;

}
