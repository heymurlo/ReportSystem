package com.company.DAL;

import java.util.LinkedList;
import java.util.List;

public class Employee extends IEntity {

    private String Name;
    private List<Employee> Subordinaries;
    private Employee Boss;
    private List<Task> Tasks;
    private List<Report> Reports;

    public Employee(String name, int id) {
        Name = name;
        Id = id;
        Tasks = new LinkedList<>();
        Subordinaries = new LinkedList<>();
    }

    @Override
    public int GetId() {
        return Id;
    }

    public String GetName() {
        return Name;
    }

    public List<Task> GetTasks() {
        return Tasks;
    }

    public List<Employee> GetSubordinates() {
        return this.Subordinaries;
    }

    public void AddSubordinate(Employee Empl) {
        Subordinaries.add(Empl);
    }

    public void AddTask(Task task) {
        Tasks.add(task);
    }

    public void AddReport(Report rep) {
        Reports.add(rep);
    }

    public void AddToReport(String Task) {

    }

    public Employee GetBoss() {
        return Boss;
    }

    public void SetBoss(Employee boss) {
        this.Boss = boss;
    }

    public boolean IsBoss() {
        return (Boss == null);
    }

    public boolean IsHead() {
        return Boss != null && Subordinaries != null;
    }


}
