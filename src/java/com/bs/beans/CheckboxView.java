package com.bs.beans;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class CheckboxView {
         
    private String[] selectedCities;   
    private List<String> cities;
     private int test3;

   
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
        
    }
    
    public String[] getSelectedCities() {
        return selectedCities;
    }
   public void doIn(){
       test3=selectedCities.length;
   }
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
 
    public List<String> getCities() {
        return cities;
    }
    
     public int getTest3() {
        return test3;
    }

    public void setTest3(int test3) {
        this.test3 = test3;
    }
    
}