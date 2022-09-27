package steps;

import base.SabitDegiskenlerEnumList;
import hb.HB_Elements;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.logging.Logger;

public class YorumOkumaStepDefs {

    Logger log = Logger.getLogger(YorumOkumaStepDefs.class.getName());

    HB_Elements hbElements = new HB_Elements();

    @Given("Kullanicinin hepsiburada {string} oldugu teyit edilir")
    public void kullanicininHBdeOlduguTeyitEdilir(String sayfaAdi) {
        Assert.assertEquals(hbElements.driver.getTitle(), SabitDegiskenlerEnumList.valueOf(sayfaAdi).getBasliklar());
    }

    @Given("Arama cubuguna {string} yaz ve yaziyi dogrula")
    public void aramaCubugunaYazVeYaziyiDogrula(String aramaUrunu) {
        hbElements.sendKeys(hbElements.searchBox, aramaUrunu);
        log.info("Arama çubuğuna " + aramaUrunu + " değeri yazıldı.");
        hbElements.waitFor(2);
    }

    @Given("{string} tusuna bas")
    public void tusunaBas(String keys) {
        hbElements.pressToKeyboard(Keys.valueOf(keys));
        log.info(keys + " tuşuna basıldı");
        hbElements.waitForPageLoad(5);
    }

    @Given("Arama cubugunda {string} degerinin aratildigini dogrula")
    public void aramaCubugundaDegerininAratildiginiDogrula(String aramaUrunu) {
        //UTF-8 nedeniyle kullanılmamıştır.
        hbElements.waitForPageLoad(3);
        Assert.assertEquals(hbElements.searchBox.getAttribute("value"), aramaUrunu);
        log.info("Yazım doğrulandı");
    }

    @Given("Ilk urunun detayini ac")
    public void ilkUrununDetayiniAc() {
        hbElements.waitFor(10);
        hbElements.elementToClickable(hbElements.firstItemTextElement);
        hbElements.waitForPageLoad(5);
        log.info("İlk ürünün detayı açıldı");
    }

    @Given("Son tabi ac ilk tabi kapat")
    public void sonTabiAcIlkTabiKapat() {
        hbElements.changeToLastTab();
        System.out.println("2");
        log.info("tab değiştirildi");
    }

    @Given("Degerlendirme yazisina tikla")
    public void degerlendirmeYazisinaTikla() {
        hbElements.waitForPageLoad(10);
        hbElements.elementToClickable(hbElements.commentTextElement);
        log.info("değerlendirme yazısı açıldı");
        hbElements.waitFor(5);
    }

    @Given("Ilk yorumun icerigini al")
    public void ilkYorumunIceriginiAl() {
        hbElements.waitForPageLoad(3);
        log.info("İlk yorum:\n-" + hbElements.firstCommentTextElement.getText());
    }

    @Given("Ilk yorum icin begen butonuna tikla")
    public void ilkYorumIcinBegenButonunaTikla() {
        hbElements.waitForPageLoad(5);
        hbElements.elementToClickable(hbElements.firstLikeButton);
    }

    @Given("Ekrandaki Tesekkur Ederiz yazisini dogrula")
    public void ekrandakiYazisiniDogrula() {
        //Burassı genel yazılar için olacaktı ancak UTF-8
        // bariyerine takıldığım için önlem amaçlı sadece Teşekkür Ederiz yazısını eklettim
        hbElements.isDisplay(hbElements.tesekkurEderizTextElement);
    }


}
