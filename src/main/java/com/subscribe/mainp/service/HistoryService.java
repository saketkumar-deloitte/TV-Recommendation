package com.subscribe.mainp.service;

import com.subscribe.mainp.dto.HistoryDto;
import com.subscribe.mainp.entity.History;
import com.subscribe.mainp.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService implements HistoryImpl{

    @Autowired
    HistoryRepository historyRepository;

    @Override
    public History saveHistory(HistoryDto hist) {
        History his = new History();
        his.setMovieId(hist.getMovieId());
        his.setUserId(hist.getUserId());
        his.setGenre("Comedy");
        return historyRepository.save(his);
    }

    @Override
    public void deleteHistory(int id) {
        historyRepository.deleteById(id);
    }

    @Override
    public List<History> getHistoryByUserId(int id) {
        List<History> hist = historyRepository.findByUserId(id);
        return hist;
    }

}
