package com.company;

import com.company.BLL.*;
import com.company.DAL.*;
import com.company.UIL.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        IRepository<Task> TaskRep = null;
        IRepository<Employee> EmplRep = null;
        IRepository<Report> ReportRep = null;

        Service s = new Service(TaskRep, EmplRep, ReportRep);
        Controller c = new Controller(s);

        TaskVM t = new TaskVM("OOP", "abdabda", 1);
        EmployeeVM e = new EmployeeVM("Petya", 228);
        ReportVM r = new ReportVM("MyReport", "Postavte 3", 3, e);

        e.AddTask(t);
        c.AddTask(t);

        List<TaskVM> l = c.GetTasks();
        for (TaskVM tsk : l) {
            System.out.println(tsk.GetName() + " " + tsk.GetDescription());
        }
    }
}
