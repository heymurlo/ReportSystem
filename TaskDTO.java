package com.company.BLL;

import com.company.DAL.Employee;
import com.company.DAL.IEntity;
import com.company.DAL.TaskState;

public class TaskDTO extends IEntity {
    private String Name = "";
    private String Description = "";
    private String Comment = "";
    private Employee Responsible;
    private int Id;
    private TaskState Status;


    public TaskDTO(String name, String description, int id) {
        Name = name;
        Description = description;
        Id = id;
        Status = TaskState.open;
    }


    public void set_id(int new_id) {
    }

    public String GetName() {
        return Name;
    }

    public String GetDescription() {
        return Description;
    }

    void AddComment(String Comm) {
        Comment += Comm;
    }

    void SetState(TaskState NewState) {
        Status = NewState;
    }

    void AddResponsible(Employee Empl) {
        Responsible = Empl;
    }
}
