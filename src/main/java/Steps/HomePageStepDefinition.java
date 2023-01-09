package Steps;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.RegistrationPage;

import static Steps.Hooks.driver;

public class HomePageStepDefinition {
    HomePage homePage;
    RegistrationPage registrationPage;

    @Given("user navigate to home page")
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }
}
