package com.subscribe.mainp.entity;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Watchlist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "watchlist_uid")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "watchlist_ottid")
    private Ott ott;
    private Date date;



}