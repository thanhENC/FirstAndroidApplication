package com.DinhVanAn.test.models;

public class Restaurant {
    int resThumb;
    String resName;
    float resRate;
    int resRateCount;
    String resAddress;

    public Restaurant(int resThumb, String resName, float resRate, int resRateCount, String resAddress){
        this.resThumb = resThumb;
        this.resName = resName;
        this.resRate = resRate;
        this.resRateCount = resRateCount;
        this.resAddress = resAddress;
    }

    public int getResThumb() {
        return resThumb;
    }

    public void setResThumb(int resThumb) {
        this.resThumb = resThumb;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public float getResRate() {
        return resRate;
    }

    public void setResRate(float resRate) {
        this.resRate = resRate;
    }

    public int getResRateCount() {
        return resRateCount;
    }

    public void setResRateCount(int resRateCount) {
        this.resRateCount = resRateCount;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }
}
