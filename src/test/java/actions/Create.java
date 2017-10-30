package actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Create implements Interaction {
    public static Create aSession() {
        {return instrumented(Create.class);}
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //TODO: GEERT, HIER WAS JE GEBLEVEN, MET HET INLOGGEN OP DE MOCK
        //given().
        System.out.println("Dit is een test");
    }
}
