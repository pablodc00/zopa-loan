package io.zopa.loanmanager.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.zopa.loanmanager.model.MarketFile;

public class CsvParser {

    public List<MarketFile> processInputFile(String inputFilePath) throws IOException {

        List<MarketFile> inputList = new ArrayList<MarketFile>();
        
        File inputF = new File(inputFilePath);
        InputStream inputS = new FileInputStream(inputF);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputS))) {
        
            // skip the header of the csv
            inputList = br.lines()
                    .skip(1)
                    .map(this::lineToObject)
                    .collect(Collectors.toList());
        }
        
        inputList.sort(Comparator.comparing(MarketFile::getRate));
        
        return inputList;
    }
    
    private MarketFile lineToObject(String line) {
        String[] arrayLine = line.split(",");
        
        return new MarketFile(
                arrayLine[0],
                Double.parseDouble(arrayLine[1]),
                Integer.parseInt(arrayLine[2]));
    }
}


