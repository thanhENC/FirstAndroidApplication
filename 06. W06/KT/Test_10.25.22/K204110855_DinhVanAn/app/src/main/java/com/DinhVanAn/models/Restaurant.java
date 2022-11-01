package com.DinhVanAn.models;

public class Restaurant {
//          "name": "Le Mekong",
//                  "photo": "bf_lemekong",
//                  "ratingValue": 4.6,
//                  "ratingCount": 52,
//                  "address": "46 Ter Võ Văn Tần, P. 6, Q. 3, Tp.HCM"
        String resName;
        int resThumb;
        float resRating;
        int resRatingCount;
        String resAddress;

    public Restaurant(String resName, int resThumb, float resRating, int resRatingCount, String resAddress) {
        this.resName = resName;
        this.resThumb = resThumb;
        this.resRating = resRating;
        this.resRatingCount = resRatingCount;
        this.resAddress = resAddress;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getResThumb() {
        return resThumb;
    }

    public void setResThumb(int resThumb) {
        this.resThumb = resThumb;
    }

    public float getResRating() {
        return resRating;
    }

    public void setResRating(float resRating) {
        this.resRating = resRating;
    }

    public int getResRatingCount() {
        return resRatingCount;
    }

    public void setResRatingCount(int resRatingCount) {
        this.resRatingCount = resRatingCount;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }
}
