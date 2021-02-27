package com.company.BLL;

import com.company.DAL.IEntity;


import java.util.List;
public class EmployeeDTO extends IEntity {

    private final int Id;
    private String Name;
    private List<EmployeeDTO> Subordinaries;
    private EmployeeDTO Boss;
    private List<TaskDTO> Tasks;

    public EmployeeDTO(String name, int id) {
        Name = name;
        Id = id;
    }

    public String GetName() {
        return Name;
    }

    List<TaskDTO> GetTasks() {
        return Tasks;
    }

    List<EmployeeDTO> GetSubordinates() {
        return Subordinaries;
    }

    void AddSubordinate(EmployeeDTO Empl) {
        Subordinaries.add(Empl);
    }

    EmployeeDTO GetBoss() {
        return Boss;
    }

    void SetBoss(EmployeeDTO boss) {
        Boss = boss;
    }

    public boolean IsBoss() {
        return Boss == null;
    }


}