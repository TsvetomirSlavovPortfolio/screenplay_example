package tasks;

import abilities.CallAnAPI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


public class Login implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        CallAnAPI.as(actor).callLoginService();
    }
}
