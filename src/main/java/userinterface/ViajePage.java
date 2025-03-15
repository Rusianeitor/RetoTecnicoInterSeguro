package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://test.interseguro.pe/viajes/")
public class ViajePage extends PageObject {
    public static final Target SELECTOR_DESTINO = Target.the("Selector para elegir destino de viaje").located(By.id("chooseDestination"));
    public static final Target SELECTOR_VIAJEROS = Target.the("Selector para elegir viajeros").located(By.id("box-select-traveler"));
    public static final Target BUTTON_VIAJEROS_ADULTO = Target.the("Botón adulto").located(By.cssSelector("div[class='mb-2 btn-group']>button:last-of-type"));
    public static final Target BUTTON_VIAJEROS_NIÑO = Target.the("Botón niño").located(By.cssSelector("div[class='btn-group']>button:last-of-type"));
    public static final Target INPUT_DOCUMENTO = Target.the("Input documento").located(By.cssSelector("input[placeholder='Documento']"));
    public static final Target INPUT_CELULAR = Target.the("Input celular").located(By.cssSelector("input[placeholder='Celular']"));
    public static final Target BUTTON_CONTINUAR = Target.the("Botón continuar").located(By.xpath("//button[text()='CONTINUAR']"));
    public static final Target LABEL_ERROR_DESTINO = Target.the("Mensaje de error al no seleccionar destino").located(By.cssSelector("div[class='invalid-feedback']"));
    public static final Target LABEL_ERROR_DOCUMENTO = Target.the("Mensaje de error al ingresar documento de 6 digitos").located(By.id("input-documento-live-feedback"));


}

