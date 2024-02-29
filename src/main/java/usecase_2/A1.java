package usecase_2;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
//By default Singleton scope
public class A1 {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private ObjectFactory<B1> bObjectFactory;

    @Autowired
    private B1 b;

    public String access(){
      return b.getBData();       // 40  40
     // return applicationContext.getBean(B.class).getBData() ; // 25   11
     // return bObjectFactory .getObject().getBData(); // 36   41
     //  return getBBean().getBData();   // 30 10
    }
    @Lookup
    public B1 getBBean(){
        return null;
    }

}
