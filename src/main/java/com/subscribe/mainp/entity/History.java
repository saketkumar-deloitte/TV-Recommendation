package com.subscribe.mainp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer genre;


    @Column
    private Integer rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_uid")
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_ottid")
    private Ott ott;
}
