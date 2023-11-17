/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.SpringBootVue.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lenovo
 */
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}
