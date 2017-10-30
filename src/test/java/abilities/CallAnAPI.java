package abilities;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RefersToActor;

import static net.serenitybdd.rest.SerenityRest.given;

public class CallAnAPI implements Ability, RefersToActor {

    private final String username;
    private final String password;
    private Actor actor;

    private Response response;

    public CallAnAPI(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static CallAnAPI withCredentials() {
        return new CallAnAPI("Pietje", "puk");
    }

    public void callLoginService() {
        String myJson = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
        response = given()
                .baseUri("http://localhost")
                .port(9080)
                .header("Content-Type", "application/json")
                .body(myJson)
                .when()
                .post("/login")
                .then().extract().response();
    }

    public boolean loginWasSuccesful() {
        System.out.println(response.getBody().prettyPrint());
        return response.getStatusCode() == 200;
    }

    public static CallAnAPI as(Actor actor) {
        if (actor.abilityTo(CallAnAPI.class) == null) {
            throw new ActorCannotCallAnApiException(actor.getName());
        }
        return actor.abilityTo(CallAnAPI.class).asActor(actor);
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        this.actor = actor;
        return (T) this;
    }
}
