package steps;

import abilities.CallAnAPI;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import questions.Inventory;
import questions.UserIsLoggedIn;
import tasks.Login;
import tasks.RetrieveInventory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ExampleSteps {

    @Steps
    private Login login;
    @Steps
    private UserIsLoggedIn userIsLoggedIn;
    @Steps
    private Inventory inventory;


    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^(?:|he|she) retrieves the inventory for '(.*)'")
    public void lookUpInventoryFor(String product) throws Throwable {
        theActorInTheSpotlight().attemptsTo(RetrieveInventory.forProduct(product));
    }

    @Given("(.*) is logged in")
    public void canLogIn(String actorName) throws Throwable {
        theActorCalled(actorName).can(CallAnAPI.withCredentials());
        theActorInTheSpotlight().attemptsTo(login);
        theActorInTheSpotlight().should(seeThat(userIsLoggedIn));

    }

    @Then("^the inventory is '(\\d+)'$")
    public void theInventoryIs(int expectedInventory) throws Throwable {
        theActorInTheSpotlight().should(seeThat(inventory, equalTo(expectedInventory)));
    }
}