package com.zlarbals.weightscheduler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MemberPaymentHistory {

    @Id
    @GeneratedValue
    private Long id;

}
