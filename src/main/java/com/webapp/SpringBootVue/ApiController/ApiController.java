/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.SpringBootVue.ApiController;

import com.webapp.SpringBootVue.entity.WeatherData;
import com.webapp.SpringBootVue.entity.WeatherDataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

/**
 *
 * @author Lenovo
 */
@RestController
@CrossOrigin
@RequestMapping("api/weatherdata")
public class ApiController {
    private final WeatherDataRepository weatherDataRepository;
    
    @Autowired
    public ApiController(WeatherDataRepository weatherDataRepository){
        this.weatherDataRepository = weatherDataRepository;
    }
    
    @GetMapping("/all")
    public List<WeatherData> getAllWeatherData(@PageableDefault(size = 72) Pageable pageable) {
    Page<WeatherData> page = weatherDataRepository.findAll(pageable);
    return page.getContent();
}
}


