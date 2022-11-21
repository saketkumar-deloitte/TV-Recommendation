package com.subscribe.mainp.service;

import com.subscribe.mainp.entity.Ott;

import java.util.List;

public interface OttImpl {

    public Ott getMovieByMovieId(int id);

    public List<Ott> getMovieByGenre(int genre);

    public List<Ott> getMovieByOTT(String name);

    public List<Ott> getMovieByTitle(String title);
}
