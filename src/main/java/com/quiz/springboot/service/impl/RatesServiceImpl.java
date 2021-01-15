package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.RatesDto;
import com.quiz.springboot.domain.dto.UserRateDto;
import com.quiz.springboot.domain.model.Rates;
import com.quiz.springboot.repository.RatesRepository;
import com.quiz.springboot.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatesServiceImpl implements RatesService {

    @Autowired
    private RatesRepository ratesRepository;

    @Override
    public RatesDto getAllRates() {

        RatesDto ratesDto = new RatesDto(ratesRepository.getGoodRates(), ratesRepository.getBadRates());
        return ratesDto;
    }


    @Override
    public Boolean saveRates(UserRateDto userRateDto) {

        boolean checking = ratesRepository.existsByUserName(userRateDto.getUserName());

        if (!checking){
            Rates rates = new Rates(userRateDto.isOpinion(),userRateDto.getUserName());
            ratesRepository.save(rates);
            return true;    // zwraca true gdy można zapisać ocenę
        }
        return false;
    }
}
