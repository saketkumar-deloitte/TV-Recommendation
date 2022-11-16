package com.subscribe.mainp.dto;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class subscriptionDto {

	private Long userId;
	private Long movieId;
	private Integer noOfDays;
	private Integer price;
	
}
