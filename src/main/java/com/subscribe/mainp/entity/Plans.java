package com.subscribe.mainp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String planName;
    private Integer price;
    private Integer duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ott_plans",
            joinColumns = @JoinColumn(name = "ottId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "plan_id",
                    referencedColumnName = "id"))
    private List<OttPlatforms> platformsList;

}
