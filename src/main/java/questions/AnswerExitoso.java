package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterface.PlanPage;

public class AnswerExitoso implements Question<Boolean> {

    public static AnswerExitoso toThe() {
        return new AnswerExitoso();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;

        if (PlanPage.LBL_RESUMEN.isVisibleFor(actor)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
