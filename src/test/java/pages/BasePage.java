package pages;
// Imports necesarios
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static{
        WebDriverManager.chromedriver().setup();
        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }
    //Método estático para navegar a una URL.
    public static void navigateTo(String url){
        driver.get(url);
    }
    //Método estático para cerrar la instancia del driver. 
    public static void closeBrowser(){
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la pagina utilizando un locator Xpath,
    // esperando a que esté presente en el DOM
    private WebElement Find(String locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } catch (Exception e) {
            System.out.println("Error al encontrar el elemento: " + locator);
            e.printStackTrace();
            return null;
        }
    }

    public void clickElement(String locator) {
        try {
            WebElement element = Find(locator);
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el elemento: " + locator);
            e.printStackTrace();
        }
    }

    public void write(String locator, String keysToSend) {
        try {
            WebElement element = Find(locator);
            if (element != null) {
                element.clear();
                element.sendKeys(keysToSend);
            }
        } catch (Exception e) {
            System.out.println("Error al escribir en el elemento: " + locator);
            e.printStackTrace();
        }
    }

    public void selectFromDropdownByValue(String locator, String value) {
        try {
            WebElement element = Find(locator);
            if (element != null) {
                Select dropdown = new Select(element);
                dropdown.selectByValue(value);
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar por valor en el dropdown: " + locator);
            e.printStackTrace();
        }
    }

    public void selectFromDropdownByIndex(String locator, int index) {
        try {
            WebElement element = Find(locator);
            if (element != null) {
                Select dropdown = new Select(element);
                dropdown.selectByIndex(index);
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar por índice en el dropdown: " + locator);
            e.printStackTrace();
        }
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    /**
     * Obtiene los valores de un dropdown dado su localizador.
     *
     * @param locator El localizador del dropdown.
     * @return Una lista de valores (texto) de las opciones del dropdown.
     */
    public List<String> getDropdownValues(String locator) {
        List<String> values = new ArrayList<>();
        try {
            WebElement dropdownElement = Find(locator);
            if (dropdownElement != null) {
                Select dropdown = new Select(dropdownElement);
                List<WebElement> dropdownOptions = dropdown.getOptions();
                for (WebElement option : dropdownOptions) {
                    values.add(option.getText());
                }
            } else {
                System.out.println("Dropdown no encontrado: " + locator);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los valores del dropdown: " + locator);
            e.printStackTrace();
        }
        return values;
    }

    // Método para obtener el texto del título
    public String getLocatorText(String locator) {
        try {
            WebElement titleElement = Find(locator);
            if (titleElement != null) {
                return titleElement.getText();
            } else {
                System.out.println("Elemento no encontrado: " + locator);
                return null;
            }
            
        } catch (Exception e) {
            System.out.println("Error al obtener el texto del título ");
            e.printStackTrace();
            return null;
        }
    }

    public List<WebElement> bringMeAllElements(String locator) {
        try {
            return driver.findElements(By.className(locator));
        } catch (Exception e) {
            System.out.println("Error al encontrar los elementos: " + locator);
            e.printStackTrace();
            return null;
        }
    }
   



}
