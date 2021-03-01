package com.company.UIL;

public class TaskVM {
    private int Id;
    private String Name;
    private String Description;
    public EmployeeVM Responsible;
    private String Comment = "";

    public TaskVM(String name, String description, int id) {
        Name = name;
        Description = description;
        Id = id;
    }

    public String GetName() {
        return Name;
    }

    public String GetDescription() {
        return Description;
    }

    public int GetId() {
        return Id;
    }

    public void SetResponsible(EmployeeVM empl) {
        Responsible = empl;
    }

    public String GetResponsible() {
        return Responsible.GetName();
    }

    public void AddComment(String Comm) {
        Comment += Comm;
    }

    public String GetComment() {
        return Comment;
    }
}
