package tests;

import manager.MyDataProvider;
import models.Auth;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.user().isLogOutPresent()) {
            app.user().logout();
        }
    }

    @Test (groups = {"one"})
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        String name = "Zoa";
        String lastname = "Dow" + i;

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() / 1000);

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Renata", "Dow", "renata" + i + "@mail.com", "Rr12345$");
        app.user().checkPolicy();
        // app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(), "You are logged in success");
        app.user().clickOkButton();

    }

    @Test
    public void registrationSuccessModel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Taya")
                .withLastName("Hatum")
                .withEmail("tay" + i + "@gmail.com")
                .withPassword("Ww12345$");


        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(), "You are logged in success");
        app.user().clickOkButton();

    }

    @Test(dataProvider = "regValidData", dataProviderClass = MyDataProvider.class)
    public void registrationSuccessAuth(Auth auth) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        auth.setEmail("wow" + i + "@mail.com");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(auth);
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(), "You are logged in success");
        app.user().clickOkButton();

    }

    }





