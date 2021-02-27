package com.company.UIL;

import com.company.BLL.*;
import com.company.DAL.Report;

import java.util.List;

public class Controller {
    private Service Srvc;

    public Controller(Service s) {
        Srvc = s;
    }

    public void AddTask(TaskVM Task) {
        TaskDTO NewObj = new TaskDTO(Task.GetName(), Task.GetDescription(), Task.GetId());
        Srvc.AddTask(NewObj);
    }

    public void AddReport(ReportVM Report) {
        ReportDTO NewObj = new ReportDTO(Report.GetName(), Report.GetId());
        Srvc.AddReport(NewObj);
    }

    public void AddDailyReport(ReportVM Report) {
        DailyReport NewObj = new DailyReport(Report.GetName(), Report.GetId());
        Srvc.AddReport(NewObj);
    }

    public void AddSprintReport(ReportVM Report) {
        SprintReport NewObj = new SprintReport(Report.GetName(), Report.GetId());
        Srvc.AddReport(NewObj);
    }

    public List<TaskVM> GetTasks() {
        List<TaskVM> TasksVM = null;
        List<TaskDTO> Tasks = Srvc.GetTask();
        for (TaskDTO t : Tasks) {
            TaskVM Task = new TaskVM(t.GetName(), t.GetDescription(), t.GetId());
            TasksVM.add(Task);
        }
    return TasksVM;
    }

    public List<ReportVM> GetReports() {
        List<ReportVM> ReportsVM = null;
        List<ReportDTO> DailyReports = Srvc.GetReport();
        for (ReportDTO r : DailyReports) {
            //ReportVM Report = new ReportVM(r.GetName(), r.GetContent(), r.GetId(), r.GetResponsible());
            //ReportsVM.add(Report);
        }
    return ReportsVM;
    }

}
