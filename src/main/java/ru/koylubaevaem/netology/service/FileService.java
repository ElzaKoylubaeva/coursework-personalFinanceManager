package ru.koylubaevaem.netology.service;

import au.com.bytecode.opencsv.CSVReader;
import ru.koylubaevaem.netology.model.MaxCategory;
import ru.koylubaevaem.netology.model.Response;

import java.io.*;
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

    public void saveBinData(File file, Map<String, Long> cat2Sum) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cat2Sum);
        }
    }

    public Map<String, Long> readBinData(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<String, Long>) ois.readObject();
        }
    }
}
