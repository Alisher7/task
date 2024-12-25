package org.example;

public class PersonalTask extends Task {
    private String location;

    public PersonalTask(String title, String description, String status, String location) {
        super(title, description, status);
        this.location = location;
    }

    public String toString() {
        return "PersonalTask [id=" + super.getId() + ", Наименование задачи=" + super.getTitle() + ", Описание задачи=" + super.getDescription() + ", Статус задачи=" + super.getStatus() + ", Локация=" + location + "]\n";
    }

//    @Override
//    public void setId(Integer id) {
//        super.setId(id);
//    }


}
