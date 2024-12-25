package org.example;

import java.time.LocalDate;

public class WorkTask extends Task {
    private final LocalDate deadline;

    public WorkTask(String title, String description, String status, LocalDate deadline) {
        super(title, description, status);
        this.deadline = deadline;
    }

    public String toString() {
        return "WorkTask [id=" + super.getId() + ", Наименование задачи=" + super.getTitle() + ", Описание задачи=" + super.getDescription() + ", Статус задачи=" + super.getStatus() + ", Дедлайн=" + deadline + "]\n";
    }
}