package usecase_1;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class B {
    int value= new Random().nextInt(60);
    public String getBData(){
        return value+"";
    }
}