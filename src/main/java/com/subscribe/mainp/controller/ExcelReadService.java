package com.subscribe.mainp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import com.subscribe.mainp.entity.Ott;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExcelReadService {

    public List<Ott> ReadDataFromExcel() throws EncryptedDocumentException, InvalidFormatException, IOException{

        List<Ott> list = new ArrayList<>();
        File file = new File("/home/romarutinaik/Videos/TV-Recommendation/src/main/java/com/subscribe/mainp/controller/movies.csv");
//        File file = new File( "/home/pamethi/Desktop/product track/TV-Recommendation/src/main/java/com/subscribe/mainp/controller/movies.csv");
        InputStream inputStream = new FileInputStream(file);
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {

            Ott cr = new Ott();

            if(record.getString("ID") != null)
                cr.setMovie_id(Integer.parseInt(record.getString("ID")));
            if(record.getString("Title") != null)
                cr.setMovie_name(record.getString("Title"));
       //     if(record.getString("Year") != null)
         //       cr.setYear(Integer.parseInt(record.getString("Year")));
            cr.setCategory(record.getString("Age"));
            if(record.getString("Rotten Tomatoes") != null)
                cr.setRating(Integer.parseInt(record.getString("Rotten Tomatoes")));
            if(record.getString("Netflix") != null)
                cr.setNetflix(Integer.parseInt(record.getString("Netflix")));
            if(record.getString("Hulu") != null)
                cr.setHulu(Integer.parseInt(record.getString("Hulu")));
            if(record.getString("Prime Video") != null)
                cr.setPrime(Integer.parseInt(record.getString("Prime Video")));
            if(record.getString("Disney+") != null)
                cr.setDisney(Integer.parseInt(record.getString("Disney+")));
            if(record.getString("Type") != null)
                cr.setType(Integer.parseInt(record.getString("Type")));
            if(record.getString("Genre") != null)
                cr.setGenre(Integer.parseInt(record.getString("Genre")));
            if(record.getString("Price") != null)
                cr.setPrice(Integer.parseInt(record.getString("Price")));

            list.add(cr);

        });

        return list;
    }
}