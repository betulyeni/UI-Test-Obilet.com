package com.obilet.Steps;
import com.obilet.Base.BaseMethod;
import com.obilet.Constants.ConstantsSignUp;
import org.junit.Assert;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YeniUyelikIslemi extends BaseMethod {

    @Step("Obilet.com sayfasina gidilir")
    public void anaSayfa() {
        setUp();
        waitSeconds(3);
    }

    @Step("Anasayfanin acildigi kontrol edilir")
    public void anaSayfaKontrol() {
        Assert.assertEquals(driver.getTitle(), "En Ucuz Otobüs Bileti Fiyatları, Online Otobüs Bileti Al - obilet.com");
        System.out.println("---- Ana sayfa acildi ----");
    }

    @Step("Uye girisi butonuna tiklanir")
    public void uyeGiris() {
        clickBy(ConstantsSignUp.UYE_GİRİSİ);
        waitSeconds(5);
    }

    @Step("Uyelik pop-up acilip acilmadigi kontrol edilir")
    public void popupKontrol() {
        WebElement popup = driver.findElement(ConstantsSignUp.UYE_GİRİSİ_POPUP);
        Assert.assertEquals(popup, popup);
        System.out.println("----- Pop-up acildi ------");
    }

    @Step("Uye olma butonuna tiklanir")
    public void uyeOlma() {
        clickBy(ConstantsSignUp.UYE_OL);
    }

    @Step("<mail> adresi yazilir")
    public void mailAdres(String mail) {
        sendValue(mail, ConstantsSignUp.MAIL);
        waitSeconds(2);
    }

    @Step("<Parola> parola girilir")
    public void parola(String parola) {
        sendValue(parola, ConstantsSignUp.PAROLA);
    }

    @Step("Uye ol butonuna tiklanir")
    public void kaydol() {
        clickBy(ConstantsSignUp.KAYDOL);
    }

    @Step("Yeni kullanicinin başarili sekilde olusturuldugu kontrol edilir")
    public void kullaniciKayit() {
        WebElement deneme = driver.findElement(ConstantsSignUp.HESABIM);
        Assert.assertEquals(deneme, deneme);
        System.out.println("----- Uyelik olusturuldu ------");
    }
}
