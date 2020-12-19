package com.example.familyexpenses.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long idWeather;
    @Column(name = "number")
    private String number;
    @Column(name = "month")
    private String month;
    @Column(name = "linkHref")
    private String linkHref;
    @Column(name = "img")
    private String img;
    @Column(name = "temperatureMin")
    private String temperatureMin;
    @Column(name = "temperatureMax")
    private String temperatureMax;


}
