package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import base.Driver;

public class Hook extends Driver {


    @Before
    public void before(){
        getDriver();
    }


    @After
    public void after(){
      //  closeDriver();
    }
}
