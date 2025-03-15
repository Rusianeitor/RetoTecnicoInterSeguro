package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import userinterface.ViajePage;

public class AbrirInterseguro implements Task {

    private ViajePage viajePage;

    public static AbrirInterseguro thePage() {
        return Tasks.instrumented(AbrirInterseguro.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(viajePage));
    }
}
