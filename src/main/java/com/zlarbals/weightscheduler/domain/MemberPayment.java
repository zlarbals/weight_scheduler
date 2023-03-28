package com.zlarbals.weightscheduler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MemberPayment {

    @Id
    @GeneratedValue
    private Long id;

}
