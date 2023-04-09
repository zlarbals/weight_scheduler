package com.zlarbals.weightscheduler.repository;

import com.zlarbals.weightscheduler.domain.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calender,Long> {

    void deleteAllByYear(int year);

}
