package com.pujianto131.myasynctaskloader;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class WeatherItems {
    private int id;
    private String nama;
    private String currentWeather;
    private String description;
    private String temperture;

    public WeatherItems(JSONObject object){
        try {
            int id = object.getInt("id");
            String name = object.getString("name");
            String currentWeather = object.getJSONArray("weather").getJSONObject(0).getString("main");
            String description = object.getJSONArray("weather").getJSONObject(0).getString("description");
            double tempInKelvin = object.getJSONObject("main").getDouble("temp");
            double tempInCelcius = tempInKelvin - 273;
            String temperature = new DecimalFormat("##.##").format(tempInCelcius);
            this.id = id;
            this.nama = name;
            this.currentWeather = currentWeather;
            this.description = description;
            this.temperture = temperature;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }
    public void setCurrentWeather(String currentWeather){
        this.currentWeather = currentWeather;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getTemperture() {
        return temperture;
    }
    public void setTemperture(String temperture){
        this.temperture = temperture;
    }
}
