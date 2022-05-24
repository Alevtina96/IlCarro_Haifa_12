package tests;

import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);

        logger.info("Logger");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Renata","Dow","renata"+i+"@mail.com","Rr12345$");
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");
        app.user().clickOkButton();

    }

    @Test
    public void registrationSuccessModel(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user  = new User()
                .withName("Taya")
                .withLastName("Hatum")
                .withEmail("tay"+i+"@gmail.com")
                .withPassword("Ww12345$");


        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");
        app.user().clickOkButton();

    }

    @Test
    public void registrationSuccessAuth(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Auth auth = Auth.builder()
                .name("Taya")
                .lastName("Hatum")
                .email("taya"+i+"@gmail.com")
                .password("Ww12345$").build();


        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(auth);
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");
        app.user().clickOkButton();

    }

    }





