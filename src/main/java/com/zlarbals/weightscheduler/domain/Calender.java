package com.zlarbals.weightscheduler.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "WS_CALENDER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Calender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "CALENDER_YEAR")
    private int year;

    @Column(name = "CALENDER_MONTH")
    private int month;

    @Column(name = "CALENDER_DATE")
    private LocalDate date;

    @Column(name = "WEEK_NO")
    private int weekNo;

    @Column(name = "WEEK_DAY_NO")
    private int weekDayNo;

    @CreatedDate
    @Column(updatable = false, name = "CREATED_DATE")
    private LocalDateTime createdDate;

}
