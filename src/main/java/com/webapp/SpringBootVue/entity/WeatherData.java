/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.SpringBootVue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lenovo
 */
@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dt;
    private String data;
    private String czas;
    private Double temp;
    private Double minTemp;
    private Double maxTemp;
    private Double feelsLikeTemp;
    private int pressure;
    private int humidity;
    private Double speed;
    private Double gust;
    private int deg;
    private int weatherId;
    private String main;
    private String description;
    private String icon;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    public void setFeelsLikeTemp(Double feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCzas() {
        return czas;
    }

    public void setCzas(String czas) {
        this.czas = czas;
    }
    
    @PrePersist
    protected void onCreate() {
        Instant instant = Instant.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZoneId zone = ZoneId.of("GMT");
        dt = ""+instant.getEpochSecond();
        data = instant.atZone(zone).format(dateFormatter);

        czas = instant.atZone(zone).format(timeFormatter);
    }
}
