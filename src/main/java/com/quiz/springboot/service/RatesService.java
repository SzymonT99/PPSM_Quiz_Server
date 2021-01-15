package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.RatesDto;
import com.quiz.springboot.domain.dto.UserRateDto;

public interface RatesService {

    RatesDto getAllRates();
    Boolean saveRates(UserRateDto userRateDto);
}
