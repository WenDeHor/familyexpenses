package com.example.familyexpenses.repository;

import com.example.familyexpenses.model.User;
import com.example.familyexpenses.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
