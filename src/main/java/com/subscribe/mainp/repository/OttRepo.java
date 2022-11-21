package com.subscribe.mainp.repository;

import com.subscribe.mainp.entity.Ott;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OttRepo extends JpaRepository<Ott, Integer> {

    public List<Ott> findByGenre(int Genre);

    public List<Ott> findByMoviename(String title);

    public List<Ott> findByNetflix(int netflix);

    public List<Ott> findByPrime(int prime);

    public List<Ott> findByHulu(int hulu);

    public List<Ott> findByDisney(int disney);
}
