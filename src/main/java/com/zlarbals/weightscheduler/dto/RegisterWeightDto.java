package com.zlarbals.weightscheduler.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
public class RegisterWeightDto {

    Double weight;

    LocalDate date;

}
