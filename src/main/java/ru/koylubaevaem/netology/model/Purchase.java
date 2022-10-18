package ru.koylubaevaem.netology.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Purchase {

    private String title;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate date;

    private long sum;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
