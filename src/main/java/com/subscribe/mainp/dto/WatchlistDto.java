package com.subscribe.mainp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class WatchlistDto {

    private int userId;

    @NotNull(message = "Movie Id cannot be null")
    private int movieId;

}
