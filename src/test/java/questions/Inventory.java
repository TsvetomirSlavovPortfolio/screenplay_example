package questions;

import abilities.CallAnAPI;
import model.InventoryResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Inventory implements Question<Integer> {
    public Inventory() {
        }

    @Override
    public Integer answeredBy(Actor actor) {

        InventoryResponse response = CallAnAPI.as(actor).returnResponse().getBody().as(InventoryResponse.class);

        return response.getInventory();
    }
}
