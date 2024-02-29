package com.example.beans.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private ObjectFactory<WeatherService> weatherServiceObjectFactory;

    public String getCurrentTempFromWeatherAPI() {
        // return weatherService.getTodaysTemp();        -> comment response-> ["2023-12-27T17:27:32.957042->48", "2023-12-27T17:27:32.957042->48]
        // return applicationContext.getBean(WeatherService.class).getTodaysTemp();     -> ["2023-12-27T17:31:09.629679700->29", "2023-12-27T17:31:10.641506400->44"]
        // return weatherServiceObjectFactory.getObject().getTodaysTemp();          //["2023-12-27T17:33:02.081757100->12", "2023-12-27T17:33:03.095117300->42"]
        return getWeatherServiceBean().getTodaysTemp();  // ["2023-12-27T17:34:49.893594700->56","2023-12-27T17:34:50.904596800->26"]
    }

    @Lookup
    public WeatherService getWeatherServiceBean(){
        return null;
    }
}