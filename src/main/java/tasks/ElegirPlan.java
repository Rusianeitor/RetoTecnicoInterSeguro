package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.PlanPage;

public class ElegirPlan implements Task {

    public static ElegirPlan onThePage() {
        return Tasks.instrumented(ElegirPlan.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PlanPage.BUTTON_PLAN));
    }

}
