package com.subscribe.mainp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    @Column
    private Date viewDate;
}
