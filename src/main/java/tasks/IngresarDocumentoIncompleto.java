package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.ViajePage;

public class IngresarDocumentoIncompleto implements Task {

    private final String documento;

    public IngresarDocumentoIncompleto(String documento) {
        this.documento = documento;
    }

    public static IngresarDocumentoIncompleto onThePage(String documento) {
        return Tasks.instrumented(IngresarDocumentoIncompleto.class, documento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(documento).into(ViajePage.INPUT_DOCUMENTO)
        );
    }
}
