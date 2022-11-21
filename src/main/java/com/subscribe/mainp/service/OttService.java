package com.subscribe.mainp.service;

import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.exceptions.ResourceNotFoundException;
import com.subscribe.mainp.repository.OttRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OttService implements OttImpl{

    @Autowired
    OttRepo repo;

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

}
