package com.subscribe.mainp.service;

import com.subscribe.mainp.dto.HistoryDto;
import com.subscribe.mainp.entity.History;
import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.entity.User;
import com.subscribe.mainp.repository.HistoryRepository;
import com.subscribe.mainp.repository.OttRepo;
import com.subscribe.mainp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService implements HistoryImpl{

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserRepo userrepo;

    @Autowired
    OttRepo ottRepo;

    public History saveHistory(HistoryDto historyDto) {
        User user = this.userrepo.findById(historyDto.getUserId()).get();
        Ott ott = this.ottRepo.findById(historyDto.getMovieId()).get();
        History history = new History();
        history.setOtt(ott);
        history.setGenre(ott.getGenre());
        history.setUser(user);
        return this.historyRepository.save(history);
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
