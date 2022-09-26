package steps;

import base.SabitDegiskenlerEnumList;
import hb.HB_Elements;
import io.cucumber.java.en.Given;
import org.mockito.Mockito;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class YorumOkumaStepDefs {

    HB_Elements hbElements=new HB_Elements();
    @Given("Kullanicinin hepsiburada {string} oldugu teyit edilir")
    public void kullanicininHBdeOlduguTeyitEdilir(String sayfaAdi) {
        Assert.assertEquals(hbElements.driver.getTitle(), SabitDegiskenlerEnumList.valueOf(sayfaAdi).getBasliklar());
    }
    @Given("Kullanici {string} icin arama islemi yapar")
    public void kullanici_arama_islemi_yapar(String item) {
        hbElements.sendKeys(hbElements.searchBox,item);
        hbElements.pressToKeyboard(Keys.ENTER);
        hbElements.waitForPageLoad(5);
        System.out.println("1");
    }
    @Given("Kullanici arama sonucunda gelen urun listesinden urun secer ve urun detay sayfasina gider")
    public void kullanici_arama_sonucunda_gelen_urun_listesinden_urun_secer_ve_urun_detay_sayfasina_gider() {
        hbElements.waitFor(10);
        hbElements.elementToClickable(hbElements.firstItemTextElement);
        hbElements.waitForPageLoad(5);
        hbElements.changeToLastTab();
        System.out.println("2");
    }
    @Given("Kullanici secilen urun icin urun detayda {string} tabina gider")
    public void kullanici_secilen_urun_icin_urun_detayda_tabina_gider(String tabName) {
        hbElements.waitForPageLoad(10);
        hbElements.elementToClickable(hbElements.commentTextElement);
        System.out.println("3");
        hbElements.waitFor(5);
    }
    @Given("Kullanici gelen yorumlar icerisinde {string} yorumun {string} butonuna basar")
    public void kullanici_gelen_yorumlar_icerisinde_ilk_yorumun_evet_butonuna_basar(String indexNo,String butonName) {
        System.out.println("4");
        System.out.println("İlk yorum:\n-"+hbElements.firstCommentTextElement.getText());
        hbElements.elementToClickable(hbElements.firstLikeButton);
    }
    @Given("Kullanici {string} yazisini gorur")
    public void kullanici__yazisini_gorur(String message) {
        System.out.println(message);
        hbElements.isDisplay(hbElements.tesekkurEderizTextElement);
    }


}
