package com.company.BLL;

import com.company.DAL.IEntity;


import java.util.List;
public class EmployeeDTO extends IEntity {

    protected final int Id;
    protected String Name;
    protected List<EmployeeDTO> Subordinaries;
    protected EmployeeDTO Boss;
    protected List<TaskDTO> Tasks;
    protected SprintReport SprintRep;

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
        this.Subordinaries.add(Empl);
        Empl.Boss = this;
    }

    EmployeeDTO GetBoss() {
        return Boss;
    }

    void SetBoss(EmployeeDTO boss) {
        this.Boss = boss;
    }

    public boolean IsBoss() {
        return Boss == null;
    }

    public boolean IsHead() {
        return Subordinaries != null && Boss != null;
    }
    public void AddTask(TaskDTO Task) {
        Tasks.add(Task);
    }

    public SprintReport GetReport() {
        return SprintRep;
    }

    public void AddSprintReport(SprintReport Report) {
        for (TaskDTO tsk : Tasks) {
            Report.AddContent(tsk.GetName() + " " + tsk.GetDescription());
        }
    }

    public void RemoveTask(TaskDTO Task) {
        Tasks.remove(Task);
    }



    @Override
    public int GetId() {
        return Id;
    }
}