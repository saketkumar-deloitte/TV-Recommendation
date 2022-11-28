package com.subscribe.mainp.controller;

import java.util.List;

import com.subscribe.mainp.dto.WatchlistDto;
import com.subscribe.mainp.entity.Watchlist;
import com.subscribe.mainp.payloads.ApiResponse;
import com.subscribe.mainp.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/watchlist")
@CrossOrigin("*")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    //create Watchlist
    @PostMapping("/")
    public ResponseEntity<Watchlist> createWatchlist(@RequestBody WatchlistDto watchlistDto){
        Watchlist newWatchlist = this.watchlistService.createWatchlist(watchlistDto);
        return new ResponseEntity<>(newWatchlist, HttpStatus.CREATED);
    }
    //delete Watchlist
    @DeleteMapping("/{watchlistId}")
    public ResponseEntity<ApiResponse>deleteWatchlist(@PathVariable int watchlistId){
        this.watchlistService.deleteWatchlist(watchlistId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Watchlist Deleted Successfully", true), HttpStatus.OK);
    }
    //get by user id
    @GetMapping("/{userId}")
    public ResponseEntity<List<Watchlist>>getWatchlistByUserId(@PathVariable int userId){
        List<Watchlist> watchlist = this.watchlistService.getWatchlistByUserId(userId);
        return ResponseEntity.ok(watchlist);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<Watchlist>>getAllUsers(){
        List<Watchlist> watchlists = this.watchlistService.getAllWatchlist();
        return ResponseEntity.ok(watchlists);
    }
}