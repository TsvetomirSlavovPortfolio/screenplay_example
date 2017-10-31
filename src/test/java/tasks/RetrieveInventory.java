package tasks;

import actions.DoInventoryCall;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RetrieveInventory implements Task{

    private final String product;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DoInventoryCall.forProduct(product));
    }

    public static RetrieveInventory forProduct(String product) {
        return instrumented(RetrieveInventory.class, product);
    }

    public RetrieveInventory(String product){
        this.product = product;
    }

}
