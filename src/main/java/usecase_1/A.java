package usecase_1;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class A {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private ObjectFactory<B> bObjectFactory;

    @Autowired
    private B b;

    public String access(){
      //  return b.getBData();      //59   59
    // return applicationContext.getBean(B.class).getBData() ;  // 13   13
    // return bObjectFactory .getObject().getBData(); // 22    22
    // return getBBean().getBData();  //47   47
    return new B().getBData();   //  14  45
    }
    @Lookup
    public B getBBean(){
        return null;
    }

}
