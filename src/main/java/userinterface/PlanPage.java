package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlanPage extends PageObject {
    public static final Target BUTTON_CLOSE_DIALOG = Target.the("Modal promoción").located(By.cssSelector("button[aria-label='Close this dialog']"));
    public static final Target BUTTON_PLAN = Target.the("Botón plan económico").located(By.xpath("//button[text()='LO QUIERO']"));
    public static final Target LBL_RESUMEN = Target.the("Etiqueta de sección resumen de tu compra").located(By.xpath("//h5[text()='Resumen de tu compra']"));
}
