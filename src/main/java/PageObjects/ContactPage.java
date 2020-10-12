package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ContactPage extends BasePage {
    
    private By nameAndLastNameLocator=By.id("id_imie-i-nazwisko");
    private By subjectLocator=By.id("id_wybierz-temat");
    private By emailLocator=By.id("id_e-mail");
    private By contentLocator=By.id("id_tresc");
    private By checkboxLocator=By.cssSelector("[for*='id_wyrazam-zgode-na']");
    private By submitButtonLocator=By.cssSelector("[class='form-horizontal']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage goTo(String url) {
        driver.navigate().to(url);
        return this;
    }

    public ContactPage typeNameAndLastName(String nameAndLastName) {
        driver.findElement(nameAndLastNameLocator).sendKeys(nameAndLastName);
        return this;
    }

    public ContactPage typeEmail(String[] emails) {
        Random random = new Random();
        int emailIndex=random.nextInt(emails.length-1);
        driver.findElement(emailLocator).sendKeys(emails[emailIndex]);
        return this;
    }

    public ContactPage chooseSubject(int subjectIndex) {
        WebElement dropdownElement=driver.findElement(subjectLocator);
        Select dropdown= new Select(dropdownElement);
        dropdown.selectByIndex(subjectIndex);
        return this;
    }

    public ContactPage typeContent(String content) {
        driver.findElement(contentLocator).sendKeys(content);
        return this;
    }

    public ContactPage selectAcceptTerms() {
        driver.findElement(checkboxLocator).click();
        return this;
    }


    public ContactPage clickSubmit() {
        driver.findElement(submitButtonLocator).submit();
        return this;
    }

    //poniżej metoda wykorzystywana w razie przykładowej asercji - wyświetlania komunikatu
    public boolean isAlertPresents(){
        int numberOfDangerALerts=driver.findElements(By.cssSelector("[class*='alert-danger ']")).size();
        if(numberOfDangerALerts==1)
        {
            return true;
        }
        else if(numberOfDangerALerts==0){
            return false;
        } else {
            throw new IllegalArgumentException("Wrong number of alerts:there can be only one or none");
        }
    }
}
