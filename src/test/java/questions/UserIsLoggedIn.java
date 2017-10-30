package questions;

import abilities.CallAnAPI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserIsLoggedIn implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return CallAnAPI.as(actor).loginWasSuccesful();
    }
}
