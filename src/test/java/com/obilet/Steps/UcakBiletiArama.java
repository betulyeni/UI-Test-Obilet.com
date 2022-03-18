package com.obilet.Steps;

import com.obilet.Base.BaseMethod;
import com.obilet.Constants.ConstantsFlyPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class UcakBiletiArama extends BaseMethod {
    WebElement biletDonus;
    WebElement biletGidis;

    @Step("Anasayfaya gidilir")
    public void anaSayfa() {
        setUp();
    }

    @Step("Ucak butonuna tiklanir")
    public void ucak() {
        clickBy(ConstantsFlyPage.UCAK_BUTON);
    }

    @Step(value = "<nereden> <nereye> illeri secilir")
    private void neredenNereye(String nereden, String nereye) {
        waitSeconds(5);
        sendValue(nereden, ConstantsFlyPage.NEREDEN);
        System.out.println(nereden + "-" +nereye);
        waitSeconds(3);
        clickBy(ConstantsFlyPage.NEREDEN_TIKLA);
        waitSeconds(3);
        sendValue(nereye, ConstantsFlyPage.NEREYE);
        waitSeconds(3);
        clickBy(ConstantsFlyPage.NEREYE_TIKLA);
    }

    @Step("Gidis donus tarihi secilir")
    public void gidisDonus() throws InterruptedException {
        gidisDonusTarihi("departure-input");
        waitSeconds(5);
        clickElementByXpath("//div[@class='box flight-check']");
    }

    @Step("Ucak bileti bul butonuna tiklanir")
    public void ucakArama() {
        clickBy(ConstantsFlyPage.POP_UP);
        clickBy(ConstantsFlyPage.ARAMA_BUTON);
    }

    @Step("Ucuslarin listesinin geldigi kontrol edilir")
    public void ucusKontrol() {
        waitSeconds(15);
        WebElement liste = driver.findElement(ConstantsFlyPage.UCUS_LISTESI);
        Assert.assertEquals(liste, liste);
        System.out.println("----- Ucus listesi acildi ------");
    }

    @Step("Gidis ucusu secilir")
    public void gidisUcus() {
        waitSeconds(2);
        ucakBiletiSec("#outbound-journeys");
        waitSeconds(2);
        biletGidis= driver.findElement(By.cssSelector("ul#outbound-journeys > li:nth-child(" + rndm + ")"));
        System.out.println(biletGidis.getText());


    }

    @Step("Gidis ucusu icin coklu sinif var olup olmadigi kontrol edilir")
    public void gidisBiletKontrol() {
        waitSeconds(5);
        WebElement promosyon = driver.findElement(By.cssSelector("ul#outbound-journeys > li:nth-child("+BaseMethod.rndm+") > div:nth-child(1) > ul > li > div:nth-child(4) > span"));
        System.out.println(promosyon.getText());
        waitSeconds(5);
        String promosyonText = promosyon.getText();
        if (promosyonText.equals("Promosyonlu")) {
            System.out.println("----- Coklu sinif var ------");
            waitSeconds(5);
            clickBy(ConstantsFlyPage.ECO_UCUS_GIDIS);
        } else {
            System.out.println("----- Coklu sinif Yok ------");
        }
    }

    @Step("Donus ucusu secilir")
    public void donusUcus() {
        waitSeconds(15);
        ucakBiletiSec("#return-journeys");
        waitSeconds(5);
        biletDonus= driver.findElement(By.cssSelector("ul#return-journeys > li:nth-child(" + rndm + ")"));
        System.out.println(biletDonus.getText());

    }

    @Step("Donus ucusu icin coklu sinif var olup olmadigi kontrol edilir")
    public void donusBiletKontrol() {
        waitSeconds(5);
        WebElement promosyon = driver.findElement(By.cssSelector("ul#return-journeys > li:nth-child("+BaseMethod.rndm+") > div:nth-child(1) > ul > li > div:nth-child(4)> span"));
        String promosyonText = promosyon.getText();
        waitSeconds(5);
        if (promosyonText.equals("Promosyonlu")) {
            System.out.println("----- Coklu sinif var ------");
            waitSeconds(5);
            clickBy(ConstantsFlyPage.ECO_UCUS_DONUS);
        } else {
            System.out.println("----- Coklu sinif Yok ------");
        }
    }

    @Step("Odeme sayfasinin basarili sekilde açildigi kontrol eder")
    public void odemeSayfasi() {
        waitSeconds(5);
        Assert.assertEquals(driver.getTitle(), "Satın Al - obilet.com");
        System.out.println("---- Odeme sayfa acildi ----");

    }

    @Step("Odeme sayfasi ve secilen gidis donus ucusunun ayni olup olmadigi kontrol edilir")
    public void biletKontrol() {
        waitSeconds(5);
        WebElement biletGidisKontrol=driver.findElement(By.cssSelector("#journey-contact-info > div > table > tbody:nth-child(1) > tr:nth-child(2) > td > table > tbody > tr"));
        System.out.println(biletGidisKontrol.getText());
        waitSeconds(2);
        WebElement biletDonusKontrol=driver.findElement(By.cssSelector("#journey-contact-info > div > table > tbody:nth-child(2) > tr:nth-child(3)"));
        System.out.println(biletDonusKontrol.getText());
        waitSeconds(2);
        Assert.assertSame(biletGidisKontrol,biletGidis);
        Assert.assertSame(biletDonusKontrol,biletDonus);
    }


}
