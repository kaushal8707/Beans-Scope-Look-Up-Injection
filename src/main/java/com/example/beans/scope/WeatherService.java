package com.example.beans.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Scope("prototype")
public class WeatherService {

    String time = LocalDateTime.now().toString();
    int temp= new Random().nextInt(60);

    public String getTodaysTemp(){
        return time+"->"+temp;
    }
}