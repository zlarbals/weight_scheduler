package com.zlarbals.weightscheduler.repository;

import com.zlarbals.weightscheduler.domain.DailyWeight;
import com.zlarbals.weightscheduler.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailyWeightRepository extends JpaRepository<DailyWeight,Long> {

    List<DailyWeight> findDailyWeightsByMemberAndDateIn(Member member, List<LocalDate> date);

}
