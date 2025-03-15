package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.PlanPage;

public class CerrarPromocion implements Task {

    public static CerrarPromocion onThePage() {
        return Tasks.instrumented(CerrarPromocion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean isVisible = PlanPage.BUTTON_CLOSE_DIALOG.isVisibleFor(actor);
        System.out.println("Mostró? " + isVisible);
        if (isVisible == true) {
            actor.attemptsTo(
                    Click.on(PlanPage.BUTTON_CLOSE_DIALOG)
            );
        } else {
            System.out.println("No se mostró promoción");
        }

    }
}
