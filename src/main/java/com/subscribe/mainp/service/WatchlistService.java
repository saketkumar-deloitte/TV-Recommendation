package com.subscribe.mainp.service;


import com.subscribe.mainp.dto.WatchlistDto;
import com.subscribe.mainp.entity.Watchlist;

import java.util.List;

public interface WatchlistService {

    //create
    Watchlist createWatchlist(WatchlistDto watchlistDto);
    //delete
    void deleteWatchlist(int watchlistId);
    //getWatchlistById
    List<Watchlist> getWatchlistByUserId(int userId);
    //getall
    List<Watchlist> getAllWatchlist();
}
