package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.ViajePage;

public class CampoRequerido implements Question<Boolean> {

    private final String expectedText;

    public CampoRequerido(String expectedText) {
        this.expectedText = expectedText;
    }

    public static CampoRequerido toThe(String expectedText) {
        return new CampoRequerido(expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = Text.of(ViajePage.LABEL_ERROR_DESTINO).answeredBy(actor);
        System.out.println("actual text " + actualText);
        return actualText.equals(expectedText);
    }
}
