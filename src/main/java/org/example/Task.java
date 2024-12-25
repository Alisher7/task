package org.example;

import java.time.LocalDate;

public class Task {
    private Integer id;
    private String title;
    private String description;
    private String status;

    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String toString() {
        return "Task [id=" + id + ", Наименование задачи=" + title + ", Описание задачи=" + description + ", Статус задачи=" + status + "]\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



