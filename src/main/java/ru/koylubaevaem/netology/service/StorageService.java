package ru.koylubaevaem.netology.service;

import ru.koylubaevaem.netology.model.MaxCategory;
import ru.koylubaevaem.netology.model.Response;

import java.util.HashMap;
import java.util.Map;

public class StorageService {

    private static final String DEFAULT_CATEGORY = "другое";

    private Map<String, String> item2Category;

    // сумма категории
    private Map<String, Long> category2Sum = new HashMap<>();

    public void setItem2Category(Map<String, String> item2Category) {
        this.item2Category = item2Category;
    }

    public void setCategory2Sum(Map<String, Long> category2Sum) {
        this.category2Sum = category2Sum;
    }

    public Map<String, Long> getCategory2Sum() {
        return category2Sum;
    }

    public String getCategory(String item) {
        String category = item2Category.get(item);
        if (category == null) {
            category = DEFAULT_CATEGORY;
        }
        return category;
    }

    public void updateCategorySum(String category, long sum) {
        Long categorySum = category2Sum.getOrDefault(category, 0L);
        category2Sum.put(category, categorySum + sum);
    }

    public Response getMaxCategory() {
        String category = null;
        Long sum = Long.MIN_VALUE;
        for (Map.Entry<String, Long> entry : category2Sum.entrySet()) {
            if (sum < entry.getValue()) {
                category = entry.getKey();
                sum = entry.getValue();
            }
        }

        MaxCategory maxCategory = new MaxCategory();
        if (category != null) {
            maxCategory.setCategory(category);
            maxCategory.setSum(sum);
        }

        Response response = new Response();
        response.setMaxCategory(maxCategory);
        return response;
    }


}
