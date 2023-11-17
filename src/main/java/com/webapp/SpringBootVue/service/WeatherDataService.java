/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.SpringBootVue.service;

import com.webapp.SpringBootVue.entity.WeatherData;
import com.webapp.SpringBootVue.entity.WeatherDataRepository;
import dto.OpenWeatherMapResponse;
import dto.Weather;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;



/**
 *
 * @author Lenovo
 */
@Service
public class WeatherDataService {
    private final WebClient webClient;
    private final WeatherDataRepository weatherDataRepository;
    private final String apiKey;
    private final String apiUrl;
    private final String city;
    
    @Autowired
    public WeatherDataService(WebClient.Builder webClientBuilder,
                        WeatherDataRepository weatherDataRepository,
                         @Value("${openweathermap.api.key}") String apiKey,
                         @Value("${openweathermap.api.url}") String apiUrl,
                          @Value("${openweathermap.api.city}") String city) {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
        this.weatherDataRepository = weatherDataRepository;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.city=city;
    }
    @Scheduled(fixedRate=300000)
    public void collectWeatherdata(){
        //url=BASE_URL+"appid="+API_KEY+"&q="+CITY+"&lang=pl"+"&exclude=current"
        String requestUrl=apiUrl+"?appid="+apiKey+"&q="+city+"&lang=pl"+"&exclude=current&units=metric";
        System.out.println(requestUrl);
        try{
            OpenWeatherMapResponse response = webClient.get()
                    .uri(requestUrl)
                    .retrieve()
                    .bodyToMono(OpenWeatherMapResponse.class)
                    .block();
            
            if (response!=null){
                
                System.out.println("response: "+response);
                Double temp = response.getMain().getTemp();
                Double minTemp = response.getMain().getTemp_min();
                Double maxTemp = response.getMain().getTemp_max();
                Double feelsLikeTemp = response.getMain().getFeels_like();
                int humidity = response.getMain().getHumidity();
                int pressure = response.getMain().getPressure();
                Double speed = response.getWind().getSpeed();
                Double gust = response.getWind().getGust();
                int deg = response.getWind().getDeg();
                List<Weather> weatherList=response.getWeather();
                int weatherId =weatherList.get(0).getId();
                String main=weatherList.get(0).getMain();
                String description=weatherList.get(0).getDescription();
                String icon=weatherList.get(0).getIcon();
                WeatherData weatherData = new WeatherData();
                
                weatherData.setTemp(temp);
                weatherData.setMinTemp(minTemp);
                weatherData.setMaxTemp(maxTemp);
                weatherData.setFeelsLikeTemp(feelsLikeTemp);
                weatherData.setHumidity(humidity);
                weatherData.setPressure(pressure);
                weatherData.setGust(gust);
                weatherData.setSpeed(speed);
                weatherData.setDeg(deg);
                weatherData.setWeatherId(weatherId);
                weatherData.setMain(main);
                weatherData.setDescription(description);
                weatherData.setIcon(icon);


                weatherDataRepository.save(weatherData);
            }
        }
        catch(Exception e){
        System.out.println("Błąd:"+e);
        }
//        
        //system.println        
    }
}
