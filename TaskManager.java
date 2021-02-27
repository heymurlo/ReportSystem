package com.company.BLL;


import com.company.DAL.TaskState;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private List<TaskDTO> Tasks;
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

    public List<TaskDTO> GetByEmployee(EmployeeDTO empl) {
        return empl.GetTasks();
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
        List<TaskDTO> Tasks = null;
        List<EmployeeDTO> Subords = empl.GetSubordinates();
        for (EmployeeDTO s : Subords) {
            for (TaskDTO t : s.GetTasks()) {
                Tasks.add(t);
            }
        }
        if (empl.GetSubordinates().isEmpty()) {
            System.out.println("Employee has no subordinates");
        }
    return Tasks;
    }
}
