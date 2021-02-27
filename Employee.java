package com.company.DAL;

import java.util.List;
public class Employee extends IEntity{

    private String Name;
    private List<Employee> Subordinaries;
    private Employee Boss;
    private List<Task> Tasks;

    public Employee(String name, int id) {
        Name = name;
        Id = id;
    }

    public String GetName() {
        return Name;
    }

     List<Task> GetTasks() {
        return Tasks;
    }

     List<Employee> GetSubordinates() {
        return Subordinaries;
    }

    void AddSubordinate(Employee Empl) {
        Subordinaries.add(Empl);
    }

     Employee GetBoss() {
        return Boss;
    }

    void SetBoss(Employee boss) {
        Boss = boss;
    }


}
