package com.subscribe.mainp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ott {

    @Id
    private Integer movie_id;

    private String moviename;

    private String category;

    private Integer rating;

    private Integer netflix;

    private Integer hulu;

    private Integer prime;

    private Integer disney;

    private Integer type;

    private Integer genre;
}
