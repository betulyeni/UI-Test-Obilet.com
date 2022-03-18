package com.obilet.Constants;

import org.openqa.selenium.By;

public class ConstantsFlyPage {
    public static final By UCAK_BUTON = By.xpath("//ul[@class= 'menu left']//li[2]");
    public static final By NEREDEN = By.cssSelector("[id='origin-input']");
    public static final By NEREYE = By.cssSelector("[id='destination-input']");
    public static final By NEREDEN_TIKLA = By.cssSelector("#origin > div > ul > li:nth-child(1)");
    public static final By NEREYE_TIKLA= By.cssSelector("#destination > div > ul > li:nth-child(1)");
    public static final By POP_UP = By.xpath("//div[@class='cookies-policy']//div//a[@class='close']");
    public static final By ARAMA_BUTON = By.id("search-button");
    public static final By UCUS_LISTESI = By.id("outbound-journeys");
    public static final By GIDIS_UCUS = By.cssSelector("#outbound-journeys");
    public static final By DONUS_UCUS = By.cssSelector("#return-journeys");
    public static final By ECO_UCUS_DONUS = By.cssSelector("#return-journeys > li > div.details.row > ul > li > ul > li:nth-child(1) > div > div:nth-child(2) > .price");
    public static final By ECO_UCUS_GIDIS = By.cssSelector("#outbound-journeys > li > div.details.row > ul > li > ul > li:nth-child(1) > div > div:nth-child(2) > .price");


}
