package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ViajePage;

public class CotizarSinDestino implements Task {

    public static CotizarSinDestino onThePage() {
        return Tasks.instrumented(CotizarSinDestino.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ViajePage.BUTTON_CONTINUAR)
        );
    }
}
