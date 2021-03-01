package com.company.UIL;

import java.util.LinkedList;
import java.util.List;

public class EmployeeVM {
    private final String Name;
    private int Id;
    public List<TaskVM> Tasks;

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<TaskVM> getTasks() {
        return Tasks;
    }

    public void setTasks(List<TaskVM> tasks) {
        Tasks = tasks;
    }

    public EmployeeVM getBoss() {
        return Boss;
    }

    public void setBoss(EmployeeVM boss) {
        Boss = boss;
    }

    public List<EmployeeVM> getSubordinates() {
        return Subordinates;
    }

    public void setSubordinates(List<EmployeeVM> subordinates) {
        Subordinates = subordinates;
    }

    private EmployeeVM Boss;
    private List<EmployeeVM> Subordinates;

    public EmployeeVM(String name, int id) {
        Name = name;
        Id = id;
        Tasks = new LinkedList<>();
    }

    public void AddTask(TaskVM Task) {
        Tasks.add(Task);
        Task.SetResponsible(this);
    }

    public void RemoveTask(TaskVM task) {
        Tasks.remove(task);
    }


    public String GetName() {
        return Name;
    }

    public List<EmployeeVM> GetSubordinates() {
        return Subordinates;
    }
}
