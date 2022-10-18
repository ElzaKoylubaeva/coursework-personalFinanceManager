package ru.koylubaevaem.netology.model;

public class MaxCategory {

    private String category;

    private Long sum;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "MaxCategory{" +
                "category='" + category + '\'' +
                ", sum=" + sum +
                '}';
    }
}
