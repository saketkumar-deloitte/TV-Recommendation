package com.subscribe.mainp.service;

import com.subscribe.mainp.entity.History;
import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.exceptions.ResourceNotFoundException;
import com.subscribe.mainp.repository.OttRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OttService implements OttImpl{

    @Autowired
    OttRepo repo;

    @Autowired
    HistoryService historyService;

    @Override
    public Ott getMovieByMovieId(int id) {
        Ott show = this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie", "id", id));
        return show;
    }

    @Override
    public List<Ott> getMovieByGenre(int genre) {
        List<Ott> shows = repo.findByGenre(genre);
        return shows;
    }

    @Override
    public List<Ott> getMovieByOTT(String ottName) {

        List<Ott> shows = null;

        if(ottName.equalsIgnoreCase("netflix"))
             shows = repo.findByNetflix(1);

        else if(ottName.equalsIgnoreCase("prime"))
            shows = repo.findByPrime(1);

        else if(ottName.equalsIgnoreCase("hulu"))
            shows = repo.findByHulu(1);

        else if(ottName.equalsIgnoreCase("disney"))
            shows = repo.findByDisney(1);

        return shows;
    }

    @Override
    public List<Ott> getMovieByTitle(String Title) {
        List<Ott> shows = repo.findByMoviename(Title);
        return shows;
    }

    @Override
    public List<Ott> getRecommendations(int id) {
        List<History> hist=  historyService.getHistoryByUserId(id);

        Set<Integer> set = new HashSet<>();

        for(History h : hist)
        {
            set.add(h.getGenre());
        }

        List<Ott> ott = new ArrayList<>();

        for(Integer g : set)
        {
            ott.addAll(repo.findShowByGenre(g));
        }
       // ott.sort((a,b) -> (b.getRating() - a.getRating()));
        return ott;
    }

    @Override
    public List<Ott> getMovies()
    {
        return repo.findMovies();
    }

    @Override
    public List<Ott> getSeries()
    {
        return repo.findSeries();
    }
}
