package com.eurotech.tests.day20_DDF;

import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {



    @DataProvider
    public Object [][] tvAndRating(){

        String [][] data = {
                {"eurotech@gmail.com","Test12345!"},
                {"Sherlock Holmes","9"},
                {"Lord Of The Rings","8"},
                {"Breaking Bad","9"},
                {"Prison Break","8"},
                {"Viking","7"},
                {"Kurtlar Vadisi","9"},
                {"Arrow","7"}
        };

        return data;
    }

    @Test(dataProvider = "tvAndRating")
    public void testTvShow(String tvShow,String rating) {



        System.out.println("Tv Show "+tvShow+" has rating "+rating);


    }
}
