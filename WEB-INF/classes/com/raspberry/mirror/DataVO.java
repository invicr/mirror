// 
// Decompiled by Procyon v0.5.36
// 

package com.raspberry.mirror;

public class DataVO
{
    private String baseDate;
    private String baseTime;
    private String location;
    private String temperature;
    private String skyCondition;
    private String precipitationForm;
    
    public String getBaseDate() {
        return this.baseDate;
    }
    
    public void setBaseDate(final String baseDate) {
        this.baseDate = baseDate;
    }
    
    public String getBaseTime() {
        return this.baseTime;
    }
    
    public void setBaseTime(final String baseTime) {
        this.baseTime = baseTime;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(final String location) {
        this.location = location;
    }
    
    public String getTemperature() {
        return this.temperature;
    }
    
    public void setTemperature(final String temperature) {
        this.temperature = temperature;
    }
    
    public String getSkyCondition() {
        return this.skyCondition;
    }
    
    public void setSkyCondition(final String skyCondition) {
        this.skyCondition = skyCondition;
    }
    
    public String getPrecipitationForm() {
        return this.precipitationForm;
    }
    
    public void setPrecipitationForm(final String precipitationForm) {
        this.precipitationForm = precipitationForm;
    }
}