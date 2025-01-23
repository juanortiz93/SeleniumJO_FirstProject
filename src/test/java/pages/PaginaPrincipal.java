package pages;

import java.net.URL;

import org.openqa.selenium.WebDriver;

public class PaginaPrincipal extends BasePage{

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal() {
        super(driver);
    }

    // Método para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        String url = "https://www.freerangetesters.com";
        if (isValidURL(url)) {
            navigateTo(url);
        } else {
            System.out.println("URL no válida: " + url);
        }
    }

    // Método para hacer clic en una sección de la barra de navegación
    public void clickOnSectionNavigationBar(String section) {
        try {
            // Reemplaza el marcador de posición en sectionLink con el nombre
            String xpathSection = String.format(sectionLink, section);
            clickElement(xpathSection);
        } catch (Exception e) {
            System.out.println("Error al hacer clic en la sección: " + section);
            e.printStackTrace();
        }
    }

    // Método para hacer clic en el botón "Elegir Plan"
    public void clickOnElegirPlanButton() {
        try {
            clickElement(elegirPlanButton);
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el botón 'Elegir Plan'");
            e.printStackTrace();
        }
    }

    // Método para validar la URL
    private boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
