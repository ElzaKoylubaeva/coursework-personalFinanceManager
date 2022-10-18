package ru.koylubaevaem.netology.model;

public class Response {

    private MaxCategory maxCategory;

    public MaxCategory getMaxCategory() {
        return maxCategory;
    }

    public void setMaxCategory(MaxCategory maxCategory) {
        this.maxCategory = maxCategory;
    }

    @Override
    public String toString() {
        return "Response{" +
                "maxCategory=" + maxCategory +
                '}';
    }
}
