package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaCursos extends BasePage {
    
    // Localizador para el enlace "Introducción al Testing de Software"
    private String fundamentosTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    public PaginaCursos(){
        super(driver);
    }

    public String getFundamentosTestingLink() {
        return fundamentosTestingLink;
    }

    public void clickFundamentosTestingLink(){
        try {
            clickElement(getFundamentosTestingLink());
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el enlace 'Introducción al Testing de Software'");
            e.printStackTrace();
        }
        
    }


}
