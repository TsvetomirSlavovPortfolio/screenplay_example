package actions;

import abilities.CallAnAPI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoInventoryCall implements Interaction {
    String path = "/inventory";
    String searchbody;

    public DoInventoryCall(String searchbody) {
        this.searchbody = searchbody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CallAnAPI.as(actor).callService(path, searchbody);
    }

    public static DoInventoryCall forProduct(String product) {
        String searchbody = String.format("{\"product\":\"%s\"}", product);

        return instrumented(DoInventoryCall.class, searchbody);
    }
}
