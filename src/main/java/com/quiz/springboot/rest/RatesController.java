package com.quiz.springboot.rest;

import com.quiz.springboot.domain.dto.RatesDto;
import com.quiz.springboot.domain.dto.UserRateDto;
import com.quiz.springboot.service.RatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
public class RatesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RatesService ratesService;

    @GetMapping("/rates")
    public ResponseEntity<RatesDto> getRates() {

        RatesDto ratesDto = ratesService.getAllRates();

        LOGGER.info("--- good rates: {}", ratesDto.getGoodRates());
        LOGGER.info("--- bad rates: {}", ratesDto.getBadRates());

        return new ResponseEntity<>(ratesDto, HttpStatus.OK);
    }

    @PostMapping("/add-rate")
    public ResponseEntity<Boolean> addQuestion(@RequestBody UserRateDto userRateDto) {

        LOGGER.info("--- user: {}", userRateDto.getUserName());
        LOGGER.info("--- positive opinion: {}", userRateDto.isOpinion());

        boolean state = ratesService.saveRates(userRateDto);

        return new ResponseEntity<>(state, HttpStatus.OK);
    }
}
