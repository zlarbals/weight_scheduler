package com.zlarbals.weightscheduler.service;

import com.zlarbals.weightscheduler.domain.Calender;
import com.zlarbals.weightscheduler.repository.CalenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;

    public void createCalenderByYear(int year){

        calenderRepository.deleteAllByYear(year);

        for(int month=1;month<=12;month++){
            LocalDate standardDate = LocalDate.of(year,month,1);
            LocalDate firstDateByMonth = standardDate.withDayOfMonth(1);
            LocalDate lastDateByMonth = standardDate.withDayOfMonth(standardDate.lengthOfMonth());

            for (LocalDate date = firstDateByMonth; date.isBefore(lastDateByMonth) || date.isEqual(lastDateByMonth);date = date.plusDays(1)){
                Calender calender = Calender.builder()
                        .year(date.getYear())
                        .month(date.getMonthValue())
                        .date(date)
                        .weekNo(date.get(WeekFields.ISO.weekOfYear()))
                        .weekDayNo(date.getDayOfWeek().getValue())
                        .build();

                calenderRepository.save(calender);
            }

        }

    }

}
