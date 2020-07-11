package com.deerlili.spring.cloud.weather.controller;


import com.deerlili.spring.cloud.weather.entity.City;
import com.deerlili.spring.cloud.weather.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    public static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityid/{cityid}")
    public ModelAndView getReportByCityId(@PathVariable("cityid") String cityid,Model model) throws Exception {
        // TODO 改为由城市数据API微服务来提供数据

        List<City> cityList = null;
        try {
            // TODO 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            city.setCityName("深圳");
            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        model.addAttribute("title","deerlili天气预报");
        model.addAttribute("cityId",cityid);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report",weatherReportService.getDataByCityId(cityid));
        return new ModelAndView("weather/report","reportModel",model);
    }

}
