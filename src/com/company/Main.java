package com.company;

import com.company.BLL.*;
import com.company.DAL.*;
import com.company.UIL.*;

import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        IRepository<Task> TaskRep = new IRepository<>();
        IRepository<Employee> EmplRep = new IRepository<>();
        IRepository<Report> ReportRep = new IRepository<>();

        Service s = new Service(TaskRep, EmplRep, ReportRep);
        Controller c = new Controller(s);

        EmployeeVM id1 = c.CreateEmployee("Petya", 0, 0);
        EmployeeVM id2 = c.CreateEmployee("Helen", 1, 0);
        EmployeeVM id3 = c.CreateEmployee("Vasya Poopkin", 2, 0);
        EmployeeVM id4 = c.CreateEmployee("Igor Zalupkin", 3, 1);


        TaskVM task1 = c.CreateTask("OOP", "поставьте тройку умоляю", 0, 2);
        TaskVM task2 = c.CreateTask("Still OOP", "по троечке и разбежались", 1, 1);


        //System.out.println(c.GetTaskById(0));
        DailyReport rep1 = c.CreateDailyReport("MyReport", 0, id1);
       // c.GetReports();

        ReportVM rep2 = c.CreateSprintReport("Sprint report uraaa",  0, id2);
        c.AddContentToReport(id2, rep2);

        c.AddComment("не отправляйте на комиссию", task1);

        c.CloseReport(id1, rep2);

        c.GetTaskById(0);

       // System.out.println(task1.GetComment());

        //c.GetMyBoss(1);
         //c.GetSubords(id1);
       // c.GetTasksByEmployee(id2);


        // c.GetSubordsTasks(id1);

        //c.CreateDailyReport("new report", 0, 0);


        /*List<ReportVM> r = c.GetReports();
        for (ReportVM rep : r) {
            System.out.println(rep.GetName());
        }*/

        //e.AddTask(t);
        //c.AddTask(t, 0);
        //System.out.println(TaskRep.Get(0));
        //System.out.println(e.getBoss());
        //c.CreateEmployee("Petya", 3);
        //c.CreateTask("OOP", "postavte 3", 1, 3);

        /*List<TaskVM> l = c.GetTasks();
        for (TaskVM tsk : l) {
            System.out.println(tsk.GetName() + " " + tsk.GetDescription() + " " );
        }*/

        c.GetHierarchy();
    }
}
