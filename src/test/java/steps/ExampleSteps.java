package steps;

import abilities.CallAnAPI;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import questions.UserIsLoggedIn;
import tasks.Login;
import tasks.SerachForProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ExampleSteps {

    @Steps
    private Login login;
    @Steps
    private UserIsLoggedIn userIsLoggedIn;
    @Steps
    private SerachForProduct searchForProduct;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("(.*) retrieves the inventory of '(.*)'")
    public void lookUpInventoryFor(String actorName, String product){
     //   theActorInTheSpotlight().attemptsTo(searchForProduct);
    }

    @Given("(.*) is logged in")
    public void canLogIn(String actorName) throws Throwable {
        theActorCalled(actorName).can(CallAnAPI.withCredentials());
        theActorInTheSpotlight().attemptsTo(login);
        theActorInTheSpotlight().should(seeThat(userIsLoggedIn));

    }
}
