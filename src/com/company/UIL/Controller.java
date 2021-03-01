package com.company.UIL;

import com.company.BLL.*;
import com.company.DAL.Employee;
import com.company.DAL.Report;
import com.company.DAL.Task;

import java.util.*;
import java.util.Map;

public class Controller {
    private final Service Srvc;
    private Map<Date, TaskVM> Journal;
    Map<Integer, String> Changes;
    //private TaskManager Manage = new TaskManager();


    public Controller(Service s) {
        Srvc = s;
    }

    public void TimePoint(TaskVM Task) {
        Date date = new Date();
        Journal.put(date, Task);
    }


    /*public void AddTask(TaskVM Task, EmployeeVM employeeVM) {
        TaskDTO NewObj = new TaskDTO(Task.GetName(), Task.GetDescription(), Task.GetId());
        Srvc.AddTask(NewObj, employeeVM.getId());
    }*/

    public void AddTask(TaskVM Task, int emplId) {
        TaskDTO NewObj = new TaskDTO(Task.GetName(), Task.GetDescription(), Task.GetId());
        Srvc.AddTask(NewObj, emplId);
        TimePoint(Task);
    }

    /*public void CreateEmployee(String name, int id, int bossId) {
        //EmployeeVM empl = new EmployeeVM(name , id);
        EmployeeDTO NewObj = new EmployeeDTO(name, id);
        Srvc.AddEmployee(NewObj, bossId);
       // return empl;
    }*/

    public EmployeeVM CreateEmployee(String name, int id, int bossId) {
        EmployeeVM empl = new EmployeeVM(name , id);
        EmployeeDTO NewObj = new EmployeeDTO(name, id);
        Srvc.AddEmployee(NewObj, bossId);
        return empl;
    }

    public DailyReport CreateDailyReport(String name, int id, EmployeeVM empl) {
        DailyReport NewObj = new DailyReport(name, id);
        Srvc.AddReport(NewObj, new EmployeeDTO(empl.getName(), empl.getId()));
        Date date = new Date();
        return NewObj;
    }

   /* public void CreateSprintReport(ReportVM Report, int emplId) {
        SprintReport NewObj = new SprintReport(Report.GetName(), Report.GetId());
        Srvc.AddReport(NewObj, emplId);
    }*/

    public ReportVM CreateSprintReport(String name, int id, EmployeeVM empl) {
        ReportVM tmp = new ReportVM(name, id);
        EmployeeDTO e = new EmployeeDTO(empl.getName(), empl.getId());
        SprintReport NewObj = new SprintReport(name, id);
        Srvc.AddReport(NewObj, e);
        return tmp;
    }

    public void AddContentToReport(EmployeeVM E, ReportVM Rep) {
        Srvc.AddToReport(new EmployeeDTO(E.getName(), E.getId()), new ReportDTO(Rep.GetName(), Rep.GetId()));
    }

    public String GetReportContent(ReportVM Rep) {
        return Srvc.GetReportContent(new ReportDTO(Rep.GetName(), Rep.GetId()));
    }

    public List<TaskVM> GetTasks() {
        List<TaskVM> TasksVM = new LinkedList<>();
        List<TaskDTO> Tasks = Srvc.GetTask();
        for (TaskDTO t : Tasks) {
            TaskVM Task = new TaskVM(t.GetName(), t.GetDescription(), t.GetId());
            TasksVM.add(Task);
        }
    return TasksVM;
    }

    public List<ReportVM> GetReports() {
        List<ReportVM> ReportsVM = new LinkedList<>();
        List<ReportDTO> DailyReports = Srvc.GetReport();
        for (ReportDTO r : DailyReports) {
           ReportVM Report = new ReportVM(r.GetName(), r.GetId());
            // ReportVM Report = new ReportVM(r.GetName(), r.GetContent(), r.GetId(), r.GetResponsible());
            ReportsVM.add(Report);
        }
    return ReportsVM;
    }

    public TaskVM CreateTask(String name, String descr, int TaskId, int EmplId) {
        TaskVM Task = new TaskVM(name, descr, TaskId);
        TaskDTO NewObj = new TaskDTO(name,descr, TaskId);
        Srvc.AddTask(NewObj, EmplId);
        return Task;
        //TimePoint(name);
    }

    public void ChangeTaskState(int EmplId, int TaskId) {
        Changes.put(EmplId, "changes commited");
    }



   /* public void CreateTask(String name, String descr, int TaskId) {
        TaskVM t = new TaskVM(name, descr, TaskId);
        Srvc.AddTask(t.GetName(), t.GetDescription(), t.GetId());
    }*/

    // NEW CODE

    public String GetTaskById(int id) {
        return Srvc.GetTaskById(id).GetName();
    }

    public void GetSubords(EmployeeVM Boss) {
       /* List<Employee> l = Srvc.GetSubords(bossId);
        for (Employee t : l) {
            System.out.println(t.GetName());
        }*/
        for (Employee e: Srvc.GetSubords(Boss.getId())) {
            System.out.println(e.GetName());
        }
        //Srvc.GetSubords(bossId);
    }

    public void GetTasksByEmployee(EmployeeVM empl) {
        List<Task> l = Srvc.GetTasksByEmployee(empl.getId());
        for (Task t : l) {
            System.out.println(t.GetName());
        }
    }

    public void GetMyBoss(int id) {
        Srvc.GetMyBoss(id);
        System.out.println(Srvc.GetMyBoss(id).GetName());
    }

    public void GetSubordsTasks(EmployeeVM empl) {
        Srvc.GetSubordsTasks(empl.getId());
    }

    public void ChangeEmployee(EmployeeVM one, EmployeeVM another, TaskVM task) {
        another.AddTask(task);
        one.RemoveTask(task);
        Srvc.ChangeEmployee(new EmployeeDTO(one.getName(), one.getId()), new EmployeeDTO(another.getName(),
                another.getId()), new TaskDTO(task.GetName(), task.GetDescription(), task.GetId()));
    }

    public void AddComment(String Comm, TaskVM Task) {
        Task.AddComment(Comm);
        Srvc.AddComment(Comm, new TaskDTO(Task.GetName(), Task.GetDescription(), Task.GetId()));
    }

    public void GetByTime(Date date) {

    }

    public void CloseReport(EmployeeVM Resp, ReportVM Rep) {
        Srvc.CloseReport(new EmployeeDTO(Resp.getName(), Resp.getId()), new ReportDTO(Rep.GetName(), Rep.GetId()));
    }

    public void GetHierarchy() {
        Srvc.GetHierarchy();
    }

    public void ChangeBoss(EmployeeVM E, EmployeeVM NewBoss) {
        Srvc.ChangeBoss(new EmployeeDTO(E.getName(), E.getId()), new EmployeeDTO(NewBoss.getName(), NewBoss.getId()));
    }



}
