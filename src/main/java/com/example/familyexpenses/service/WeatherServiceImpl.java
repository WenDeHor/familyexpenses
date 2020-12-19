package com.example.familyexpenses.service;

import com.example.familyexpenses.repository.WeatherRepository;

public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
}
