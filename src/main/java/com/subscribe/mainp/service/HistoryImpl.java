package com.subscribe.mainp.service;

import com.subscribe.mainp.dto.HistoryDto;
import com.subscribe.mainp.entity.History;

import java.util.List;

public interface HistoryImpl {

    public History saveHistory(HistoryDto hist);

    public void deleteHistory(int id);

    public List<History> getHistoryByUserId(int id);
}
