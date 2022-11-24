package com.subscribe.mainp.entity;


import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class OttPlatforms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ottName;

}
