package com.subscribe.mainp.controller;

import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.repository.OttRepo;
import com.subscribe.mainp.service.HistoryService;
import com.subscribe.mainp.service.OttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OttController {

    @Autowired
    OttRepo repo;

    @Autowired
    OttService ottService;


    @PostMapping(value="/api/movies/upload")
    public String uploadData() throws Exception
    {
        ExcelReadService service = new ExcelReadService();
        repo.saveAll(service.ReadDataFromExcel());
        return "Successfull";
    }

    @GetMapping(value="/api/movies/movieID/{movie_Id}")
    public ResponseEntity<Ott> MovieId(@PathVariable int movie_Id) {

        Ott show = ottService.getMovieByMovieId(movie_Id);

        return ResponseEntity.ok(show);
    }

    @GetMapping(value="/api/movies/movieGenre/{genre}")
    public ResponseEntity<List<Ott>> Genre(@PathVariable int genre) {

        List<Ott> otts = ottService.getMovieByGenre(genre);

        if(otts.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return  ResponseEntity.ok(otts);
    }

    @GetMapping("/api/movies/movieName/{title}")
    public ResponseEntity<List<Ott>> getMovieByTitle(@PathVariable String title) {

        List<Ott> otts = ottService.getMovieByTitle(title);

        if(otts.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return  ResponseEntity.ok(otts);
    }

    @GetMapping(value="/api/movies/ottName/{ottName}")
    public ResponseEntity<List<Ott>> OTT(@PathVariable String ottName) {

        List<Ott> otts = ottService.getMovieByOTT(ottName);

        if(otts.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return  ResponseEntity.ok(otts);
    }

    @GetMapping(value="/api/movies/getRecommendations/{userID}")
    public ResponseEntity<List<Ott>> getRecommendations(@PathVariable int userID) {
        List<Ott> h = ottService.getRecommendations(userID);
        if (h.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(h));
    }

    @GetMapping(value="/api/movies/getMovies")
    public ResponseEntity<List<Ott>> getMovies() {
        List<Ott> h = ottService.getMovies();
        if (h.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(h));
    }

    @GetMapping(value="/api/movies/getSeries")
    public ResponseEntity<List<Ott>> getSeries() {
        List<Ott> h = ottService.getSeries();
        if (h.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(h));
    }

}
