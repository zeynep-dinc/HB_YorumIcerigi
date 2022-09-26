package hb;

import base.TemelIslemler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HB_Elements extends TemelIslemler {

    public HB_Elements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searchBox;

    @FindBy(xpath = "(//h3[@data-test-id='product-card-name'])[1]")
    public WebElement firstItemTextElement;

    @FindBy(xpath = "//a[@id='productReviews']")
    public WebElement commentTextElement;

    @FindBy(xpath = "(//span[@itemprop='description'])[2]")
    public WebElement firstCommentTextElement;
    //div[1]/div[2]/div[4]/div[1]/div/div[1]
    @FindBy(xpath = "//div/div[1]/div[2]/div[5]/div[1]/div/div[1]")
    public WebElement firstLikeButton;

    @FindBy(xpath = "(//span[text()='Teşekkür Ederiz.'])[1]")
    public WebElement tesekkurEderizTextElement;

}
