package ru.koylubaevaem.netology.service;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {

    public Map<String, String> readFile(File file) throws IOException {
        Map<String, String> result = new HashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader(file), '\t')) { //categories.tsv
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                String key = line[0];
                String value = line[1];
                result.put(key, value);
            }
        }
        return result;
    }
}
