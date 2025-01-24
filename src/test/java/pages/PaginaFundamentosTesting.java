package pages;



public class PaginaFundamentosTesting extends BasePage {

    

    private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";
    private String IntroduccionTestingTitle = "//h2[normalize-space()='Introducción al Testing de Software']";

    

    public PaginaFundamentosTesting(){
        super(driver);
    }

    public void clickIntroduccionTestingLink(){
        clickElement(introduccionTestingLink);
    }

    public String getIntroduccionTestingTitle(){
        
        return getLocatorText(IntroduccionTestingTitle);
    }
    
    

    

    
}
