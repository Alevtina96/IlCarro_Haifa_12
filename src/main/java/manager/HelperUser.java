package manager;
import models.Auth;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openRegistrationForm(){
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"),name);
        type(By.id("lastName"),lastName);
        type(By.id("email"),email);
        type(By.id("password"),password);


    }
    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());


    }

    public void fillRegistrationForm(Auth auth) {
        type(By.id("name"), auth.getName());
        type(By.id("lastName"), auth.getLastName());
        type(By.id("email"), auth.getEmail());
        type(By.id("password"), auth.getPassword());


    }
    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffset = rect.getWidth()/2;
        int yOffset = rect.getHeight()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).moveByOffset(-xOffset,-yOffset).click().release().perform();

    }



    public String checkMessage() {
//   1c = 1000 millis
        //pause(1000);
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText();
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void fillLoginForm(String email,String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void fillLoginForm(Auth auth) {
        type(By.id("email"),auth.getEmail());
        type(By.id("password"),auth.getPassword());
    }

    public void openLoginForm() {
        click(By.cssSelector("[href ^='/login']"));
    }

    public void login(Auth auth) {
        openLoginForm();
        fillLoginForm(auth);
        submit();
        clickOkButton();
        pause(500);

    }
}
