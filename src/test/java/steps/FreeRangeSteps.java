package steps;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    
    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT(){
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("I select Elegir plan")
    public void selectElegirPlan(){
        landingPage.clickOnElegirPlanButton();;
    }

    @And("Select Introduccion al Testing")
    public void navigateToIntro(){
        cursosPage.clickFundamentosTestingLink();
        
    }

    @Then("Introducción al Testing de Software page loads correctly")
    public void validateCurso(){
        String titulo = fundamentosPage.getIntroduccionTestingTitle();
        Assert.assertEquals(titulo,"Introducción al Testing de Software","El titulo no coincide");
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans(){
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos",
            "Academia: $176 / año • 13 productos","Free: Gratis • 3 productos");  
    
        Assert.assertEquals(listaEsperada,lista,"Los valores no coinciden con la lista esperada");
    
    }

    public void Ejemplulis(){
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        //Verificar que los valores son iguales
        Assert.assertEquals(palabraEncontrada, palabraEsperada);

        //Verificar que dos valores no son iguales
        Assert.assertNotEquals(palabraEncontrada, palabraEsperada);

        //Verificar que una condición es verdadera
        Assert.assertTrue(palabraEncontrada.contains(palabraEsperada));

        //Verificar que una condición es falsa
        Assert.assertFalse(palabraEncontrada.contains(palabraEsperada));


        //Soft Assertions: No detienen la ejecución al fallar, ideal para verificar muchas cosas pequeñas a la vez.
        soft.assertEquals(palabraEncontrada, palabraEsperada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        soft.assertNotEquals(palabraEncontrada, palabraEsperada);

        soft.assertAll();


    }

}
