package com.company.BLL;


import com.company.DAL.TaskState;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskManager {
    public List<TaskDTO> Tasks;
    Map<Date, TaskDTO> Journal;
    Map<EmployeeDTO, List<TaskDTO>> Changes;

    public void TimePoint(TaskDTO Task) {
        Date date = new Date();
        Journal.put(date, Task);
    }

    public TaskDTO GetById(int id) {
        for (TaskDTO t : Tasks) {
            if (t.GetId() == id) {
                return t;
            }
        }
    return null;
    }


    public TaskDTO GetByTime(Date date) {
        //if not null return
        //else exception
        return Journal.get(date);
    }

    /*public List<TaskDTO> GetByEmployee(EmployeeDTO empl) {
        return empl.GetTasks();
    }*/

    public void GetByEmployee(int EmplId) {

    }

    // public  by time change??

    public void CreateTask(TaskDTO Task) {
        Tasks.add(Task);
        TimePoint(Task);
    }

    public void SetStatus(TaskState NewState, TaskDTO Task, EmployeeDTO empl) {
        Task.SetState(NewState);
        TimePoint(Task);
        Changes.get(empl).add(Task);
    }

    public void AddComment(String Comm, TaskDTO Task, EmployeeDTO empl) {
        Task.AddComment(Comm);
        TimePoint(Task);
        Changes.get(empl).add(Task);
    }

    List<TaskDTO> GetSubordsTasks(EmployeeDTO empl) {
        List<TaskDTO> Tasks = new LinkedList<>();
        List<EmployeeDTO> Subords = empl.GetSubordinates();
        for (EmployeeDTO s : Subords) {
            Tasks.addAll(s.GetTasks());
        }
        if (empl.GetSubordinates().isEmpty()) {
            System.out.println("Employee has no subordinates");
        }
    return Tasks;
    }
}
