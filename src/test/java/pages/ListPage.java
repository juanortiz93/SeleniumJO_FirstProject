package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    private String searchField = "";
    private String searchResults = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage() {
        navigateTo("https://testautomationpractice.blogspot.com/"); // Cambia la URL a la de tu aplicación
        
    }

    public void enterSearchCriteria() throws InterruptedException {
        Thread.sleep(600); // Espera 2 segundos para que la página cargue completamente
        write(searchField, "Washington");
    }

    public List<String> getAllSearchResults() {
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        for (WebElement element : list) {
            stringFromList.add(element.getText());
        }
        return stringFromList;
    }

    
}
