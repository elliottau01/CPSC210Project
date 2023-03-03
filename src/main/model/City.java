package model;

import org.json.JSONObject;
import persistence.WritableObject;

public class City implements WritableObject {

    private String cityName;
    private String countryName;
    private double livingExpensesAveragePerMonth;


    //REQUIRES: livingExpensesAveragePerMonth >= 0
    //EFFECTS: Construct City with City name, Country name, and average living expenses per month
    //For average living expenses per month, it must be a positive double
    public City(String cityName, String countryName, double livingExpensesAveragePerMonth) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.livingExpensesAveragePerMonth = livingExpensesAveragePerMonth;
    }


    //EFFECTS: return the living expenses per month in that city
    public double getLivingExpenses() {
        return livingExpensesAveragePerMonth;
    }


    //EFFECTS: return the cityName of the City
    public String getCityName() {
        return cityName;
    }


    //EFFECTS: return the CountryName where the city is located
    public String getCountryName() {
        return countryName;
    }

    @Override
    public JSONObject ObjectToJson() {
        JSONObject ObjectToJson = new JSONObject();
        ObjectToJson.put("cityName", cityName);
        ObjectToJson.put("countryName", countryName);
        ObjectToJson.put("livingExpensesAveragePerMonth", livingExpensesAveragePerMonth);
        return ObjectToJson;
    }


}
