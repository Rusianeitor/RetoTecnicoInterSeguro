package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.ViajePage;

public class DocumentoInvalido implements Question<Boolean> {

    private final String expectedText;

    public DocumentoInvalido(String expectedText) {
        this.expectedText = expectedText;
    }

    public static DocumentoInvalido toThe(String expectedText) {
        return new DocumentoInvalido(expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = Text.of(ViajePage.LABEL_ERROR_DOCUMENTO).answeredBy(actor);
        System.out.println("actual text " + actualText);
        return actualText.equals(expectedText);
    }
}
