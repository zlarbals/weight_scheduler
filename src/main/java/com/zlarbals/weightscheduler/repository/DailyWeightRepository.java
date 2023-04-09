package com.zlarbals.weightscheduler.repository;

import com.zlarbals.weightscheduler.domain.DailyWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWeightRepository extends JpaRepository<DailyWeight,Long> {
}
