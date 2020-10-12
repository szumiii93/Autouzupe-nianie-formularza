package ContactForm;

import PageObjects.ContactPage;
import org.junit.jupiter.api.Test;

public class AutocompleteContactForm extends BaseTest {

    private String url="https://bluepartner.eu/pl/kontakt/";
    private String nameAndLastName="CloudServices Test,";
    private int subjectIndex =2;
    private String content="automat test CloudServices";
    private String[] emailsTab = {"example1@gmail.com","example2@gmail.com","example3@wp.pl",
            "example4@onet.pl", "example5@interia.pl", "example6@hotmail.com"};

    @Test
    public void completeForm(){
        ContactPage contactPage = new ContactPage(driver);
        contactPage.goTo(url);
        contactPage.typeNameAndLastName(nameAndLastName)
                .typeEmail(emailsTab)
                .chooseSubject(subjectIndex)
                .typeContent(content)
                .selectAcceptTerms()
                .clickSubmit();
        //Assertions.assertTrue(contactPage.isAlertPresents(),"complete form");
    }



}
