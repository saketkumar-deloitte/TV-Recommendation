package com.subscribe.mainp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HistoryDto {
    private int userId;

    @NotNull(message = "Movie Id cannot be null")
    private int movieId;
}
