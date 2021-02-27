package com.company.UIL;

import java.util.List;

public class EmployeeVM {
    private final String Name;
    private int Id;
    public List<TaskVM> Tasks;
    private EmployeeVM Boss;
    private List<EmployeeVM> Subordinates;

    public EmployeeVM(String name, int id) {
        Name = name;
        Id = id;
    }

    public void AddTask(TaskVM Task) {
        Tasks.add(Task);
        Task.SetResponsible(this);
    }


    public String GetName() {
        return Name;
    }

    public List<EmployeeVM> GetSubordinates() {
        return Subordinates;
    }
}
