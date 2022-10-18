package ru.koylubaevaem.netology.model;

import java.io.Serializable;

public class Response implements Serializable {

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
