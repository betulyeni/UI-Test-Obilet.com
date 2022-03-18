package com.obilet.Constants;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ConstantsValues {
    public static final String NEREDEN = "Ankara";
    public static final String NEREYE = "Trabzon";

    public static String search(){
        List<String> city = new ArrayList<>();
        city.add("İstanbul");
        city.add("Adana");
        city.add("Ankara");
        city.add("Denizli");
        city.add("Trabzon");
        int cityCount= 5;
        if (NEREDEN !=null) { //boş değilse
            int result= city.indexOf(NEREDEN);//CİTY İÇİNDE DEĞER VARMI?
            if (result!= -1){
                city.remove(result); //resultdaki değeri silecek.
                cityCount--;
            }
        }
        int number = (int)(Math.random() * cityCount);
        return city.get(number);
    }
}
