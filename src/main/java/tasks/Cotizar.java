package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userinterface.ViajePage;

public class Cotizar implements Task {

    private final String destino;
    private final String adulto;
    private final String niño;
    private final String documento;
    private final String celular;

    public Cotizar(String destino, String adulto, String niño, String documento, String celular) {
        this.destino = destino;
        this.adulto = adulto;
        this.niño = niño;
        this.documento = documento;
        this.celular = celular;
    }

    public static Cotizar onThePage(String destino, String adulto, String niño, String documento, String celular) {
        return Tasks.instrumented(Cotizar.class, destino, adulto, niño, documento, celular);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(destino).from(ViajePage.SELECTOR_DESTINO),
                Enter.theValue(documento).into(ViajePage.INPUT_DOCUMENTO),
                Enter.theValue(celular).into(ViajePage.INPUT_CELULAR),
                Click.on(ViajePage.SELECTOR_VIAJEROS)
        );
        int numeroAdulto = Integer.parseInt(adulto);
        int numeroNiño = Integer.parseInt(niño);
        if (numeroAdulto > 1) {
            for (short i = 1; i < numeroAdulto; i++) {
                actor.attemptsTo(
                        Click.on(ViajePage.BUTTON_VIAJEROS_ADULTO)
                );
            }
        }
        if (numeroNiño > 0) {
            for (short i = 0; i < numeroNiño; i++) {
                actor.attemptsTo(
                        Click.on(ViajePage.BUTTON_VIAJEROS_NIÑO)
                );
            }
        } else {
            System.out.println("Niños menor a 0");
        }

        actor.attemptsTo(
                Click.on(ViajePage.SELECTOR_VIAJEROS),
                Click.on(ViajePage.BUTTON_CONTINUAR)
        );
    }
}
