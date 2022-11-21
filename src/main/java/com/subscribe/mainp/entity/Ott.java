package com.subscribe.mainp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ott {

    @Id
    private Integer movie_id;
    //@Column(name="MovieTitle")
    private String moviename;
    // @Column(name="ReleaseYear")
    private String category;
    //@Column(name="MovieRating")
    private Integer rating;
    //@Column(name="Netflix")
    private Integer netflix;
    //@Column(name="Hulu")
    private Integer hulu;
    //@Column(name="AmazonPrime")
    private Integer prime;
    //@Column(name="Disney+")
    private Integer disney;
    //@Column(name="MovieType")
    private Integer type;

    @Column(name="MovieGenre")
    private int genre;

    @Column(name="MoviePrice")
    private int price;

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return moviename;
    }

    public void setMovie_name(String movie_name) {
        this.moviename = movie_name;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNetflix() {
        return netflix;
    }

    public void setNetflix(int netflix) {
        this.netflix = netflix;
    }

    public int getHulu() {
        return hulu;
    }

    public void setHulu(int hulu) {
        this.hulu = hulu;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public int getDisney() {
        return disney;
    }

    public void setDisney(int disney) {
        this.disney = disney;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
