package ru.koylubaevaem.netology.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.koylubaevaem.netology.model.MaxCategory;
import ru.koylubaevaem.netology.model.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {

    private StorageService storageService;

    @BeforeEach
    public void init() {
        storageService = new StorageService();
    }

    @Test
    public void shouldReturnMaxCategoryIfHaveData() {
        String expectedCategory = "одежда";
        Long expectedSum = 500L;

        Map<String, Long> cat2Sum = new HashMap<>();
        cat2Sum.put("еда", 100L);
        cat2Sum.put("другое", 50L);
        cat2Sum.put(expectedCategory, expectedSum);
        cat2Sum.put("канцелярия", 100L);
        storageService.setCategory2Sum(cat2Sum);


        Response response = storageService.getMaxCategory();

        assertNotNull(response);
        MaxCategory maxCategory = response.getMaxCategory();
        assertNotNull(maxCategory);
        assertEquals(expectedCategory, maxCategory.getCategory());
        assertEquals(expectedSum, maxCategory.getSum());
    }

    @Test
    public void shouldReturnMaxCategoryIfNoData() {

        Response response = storageService.getMaxCategory();

        assertNotNull(response);
        MaxCategory maxCategory = response.getMaxCategory();
        assertNotNull(maxCategory);
        assertNull(maxCategory.getCategory());
        assertNull(maxCategory.getSum());
    }
}