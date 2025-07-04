package HW_7.Data_provider;

import org.testng.annotations.DataProvider;

public class SearchTestData {

@DataProvider (name = "getSearchData")
    public Object[][] getSearchData(){
        return new Object[][]{
             //   {"батарея","Зарядні пристрої на сонячних батареях"},
                {"lego","LEGO"}
        };    
    }


}
