package com.deerlili.spring.cloud.weather.service.impl;

import com.deerlili.spring.cloud.weather.entity.Forecast;
import com.deerlili.spring.cloud.weather.entity.Weather;
import com.deerlili.spring.cloud.weather.service.WeatherReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deerlili
 * @Classname WeatherReportServiceImpl
 * @Description 天气预报接口实现
 * @Date 2020-07-09 10:20
 * @Version V1.0
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO 改为由天气数据API微服务来提供
        // 等待后面再来做，先写静态数据
        Weather data = new Weather();
        data.setCity("重庆");
        data.setGanmao("测试");
        data.setWendu("23");

        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = null;
        forecast = new Forecast();
        forecast.setDate("1日星期天");
        forecast.setHigh("23");
        forecast.setLow("20");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("2日星期天");
        forecast.setHigh("23");
        forecast.setLow("20");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("3日星期天");
        forecast.setHigh("23");
        forecast.setLow("20");
        forecastList.add(forecast);

        data.setForecast(forecastList);

        return data;
    }
}
