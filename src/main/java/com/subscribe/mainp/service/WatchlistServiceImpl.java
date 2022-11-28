package com.subscribe.mainp.service;

import java.util.Date;
import java.util.List;

import com.subscribe.mainp.dto.WatchlistDto;
import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.entity.User;
import com.subscribe.mainp.entity.Watchlist;
import com.subscribe.mainp.exceptions.ResourceNotFoundException;
import com.subscribe.mainp.repository.OttRepo;
import com.subscribe.mainp.repository.UserRepo;
import com.subscribe.mainp.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private WatchlistRepo watchlistRepo;
    @Autowired
    private UserRepo userrepo;
    @Autowired
    private OttRepo ottRepo;
    @Override
    public Watchlist createWatchlist(WatchlistDto watchlistDto) {
//        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
//        System.out.println(watchlistDto.getUserId() + " " + watchlistDto.getMovieId()+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

        User user = this.userrepo.findById(watchlistDto.getUserId()).get();
        Ott ott = this.ottRepo.findById(watchlistDto.getMovieId()).get();
        System.out.println(user);
        System.out.println(ott);
        Watchlist watchlist = new Watchlist();
        watchlist.setUser(user);
        watchlist.setOtt(ott);
        watchlist.setDate(new Date());
        return this.watchlistRepo.save(watchlist);
    }

    @Override
    public void deleteWatchlist(int watchlistId) {
        Watchlist watchlist = this.watchlistRepo.findById(watchlistId).orElseThrow(()-> new ResourceNotFoundException("Watchlist", "id", watchlistId));
        this.watchlistRepo.delete(watchlist);
    }

    @Override
    public List<Watchlist> getWatchlistByUserId(int userId) {
        List<Watchlist>watchlist = watchlistRepo.findWatchlistByUserId(userId);
        return watchlist;
    }

    @Override
    public List<Watchlist> getAllWatchlist() {
        List<Watchlist> watchlists = this.watchlistRepo.findAll();
        return watchlists;
    }


}