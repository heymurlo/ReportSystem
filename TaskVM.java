package com.company.UIL;

public class TaskVM {
    private int Id;
    private String Name;
    private String Description;
    private EmployeeVM Responsible;

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

}
