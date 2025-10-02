package pages;

import java.net.URI;
import java.net.URL;

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

    /**
     * Valida si una URL es correcta y accesible
     * @param urlStr La URL a validar
     * @return true si la URL es válida, false en caso contrario
     */
    private boolean isValidURL(String urlStr) {
        try {
            URI uri = URI.create(urlStr);
            URL url = uri.toURL();
            
            // Verifica si el esquema y el host son válidos
            return "https".equalsIgnoreCase(uri.getScheme()) 
                && url.getHost() != null 
                && !url.getHost().isEmpty();
        } catch (Exception e) {
            System.out.println("URL inválida: " + urlStr + " - Error: " + e.getMessage());
            return false;
        }
    }
}
