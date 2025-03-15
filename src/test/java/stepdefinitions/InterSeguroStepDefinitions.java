package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.AnswerExitoso;
import questions.CampoRequerido;
import questions.DocumentoInvalido;
import tasks.AbrirInterseguro;
import tasks.CerrarPromocion;
import tasks.Cotizar;
import tasks.CotizarSinDestino;
import tasks.ElegirPlan;
import tasks.IngresarDocumentoIncompleto;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class InterSeguroStepDefinitions {
    @Given("quiero cotizar un seguro de viaje")
    public void quieroCotizarUnSeguroDeCompra() {
        OnStage.theActorCalled("Jeff").wasAbleTo(AbrirInterseguro.thePage());
    }

    @When("selecciono el mas barato")
    public void seleccionoElMasBarato(DataTable dataTable) {
        List<List<String>> datos = dataTable.asLists(String.class);
        OnStage.theActorInTheSpotlight().attemptsTo(Cotizar.onThePage(datos.get(1).get(0), datos.get(1).get(1), datos.get(1).get(2), datos.get(1).get(3), datos.get(1).get(4)));
        OnStage.theActorInTheSpotlight().attemptsTo(CerrarPromocion.onThePage());
        OnStage.theActorInTheSpotlight().attemptsTo(ElegirPlan.onThePage());
    }

    @When("no selecciono destino")
    public void noSeleccionoDestino() {
        OnStage.theActorInTheSpotlight().attemptsTo(CotizarSinDestino.onThePage());
    }

    @When("ingreso documento menor a 8 digitos")
    public void ingresoDocumentoMenorADigitos(DataTable dataTable) {
        List<List<String>> datos = dataTable.asLists(String.class);
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarDocumentoIncompleto.onThePage(datos.get(1).get(0)));
    }

    @Then("se muestra el resumen de mi compra")
    public void seMuestraElResumenDeMiCompra() {
        OnStage.theActorInTheSpotlight().should(seeThat(AnswerExitoso.toThe()));
    }

    @Then("se muestra mensaje validacion por destino {string}")
    public void seMuestraMensajeValidacionDestino(String mensaje) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Se lee del feature esto: " + mensaje);
        OnStage.theActorInTheSpotlight().should(seeThat(CampoRequerido.toThe(mensaje), is(true)));
    }

    @Then("se muestra mensaje validacion por documento {string}")
    public void seMuestraMensajeValidacionDocumento(String mensaje) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Se lee del feature esto: " + mensaje);
        OnStage.theActorInTheSpotlight().should(seeThat(DocumentoInvalido.toThe(mensaje), is(true)));
    }
}
