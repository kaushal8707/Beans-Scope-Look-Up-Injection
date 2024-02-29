package usecase_2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class B1 {
    int value= new Random().nextInt(60);
    public String getBData(){
        return value+"";
    }
}