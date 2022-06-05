package tests;

import manager.MyDataProvider;
import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

import static tests.TestBase.app;

public class LoginTests  extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }
    @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessAuth(){
        logger.info("Name of method is loginSuccessAuth");
        logger.info("Test start with data : \"noa@gmail.com\",\"Nnoa12345$\"");

        app.user().openLoginForm();
        //app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.user().fillLoginForm(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        app.user().submit();

        Assert.assertEquals(app.user().checkMessage(),"Logged in success");
        logger.info("Assert check message  : \"Logged in success\"");
        app.user().clickOkButton();

    }
    @Test
    public void loginSuccessUser(){
        logger.info("Name of method is loginSuccessUser");
        logger.info("Test start with data : \"noa@gmail.com\",\"Nnoa12345$\"");

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        logger.info("Test start with data :   " +user.toString());
        app.user().openLoginForm();
        //app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.user().fillLoginForm(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        app.user().submit();

        Assert.assertEquals(app.user().checkMessage(),"Logged in success");
        logger.info("Assert check message  : \"Logged in success\"");
        app.user().clickOkButton();

    }


    }

