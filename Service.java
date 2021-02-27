package com.company.BLL;

import com.company.DAL.Employee;
import com.company.DAL.IRepository;
import com.company.DAL.Task;
import com.company.DAL.Report;

import java.util.List;

public class Service {
    private final IRepository<Task> TaskRepository;
    private final IRepository<Employee> EmployeeRepository;
    private final IRepository<Report> ReportRepository;

    public Service(IRepository<Task> tasks, IRepository<Employee> employess, IRepository<Report> reports) {
        TaskRepository = tasks;
        EmployeeRepository = employess;
        ReportRepository = reports;
    }

    public void AddTask(TaskDTO task) {
        Task NewObj = new Task(task.GetName(), task.GetDescription(), task.GetId());
        TaskRepository.Create(NewObj);
    }

    public void AddEmployee(EmployeeDTO empl) {
        Employee NewObj = new Employee(empl.GetName(), empl.GetId());
        EmployeeRepository.Create(NewObj);
    }

    public void AddReport(ReportDTO report) {
        Report NewObj = new Report(report.GetName(), report.GetId());
        ReportRepository.Create(NewObj);
    }

    public List<TaskDTO> GetTask() {
        List<Task> Tasks = TaskRepository.GetEntities();
        List<TaskDTO> TasksDTO = null;

        for (Task t : Tasks) {
            TaskDTO NewObj = new TaskDTO(t.GetName(), t.GetDescription(), t.GetId());
            TasksDTO.add(NewObj);
        }
        return TasksDTO;
    }

    public List<ReportDTO> GetReport() {
        List<Report> Reports = ReportRepository.GetEntities();
        List<ReportDTO> ReportsDTO = null;

        for (Report r : Reports) {
            ReportDTO NewObj = new ReportDTO(r.GetName(), r.GetId());
            ReportsDTO.add(NewObj);
        }
        return ReportsDTO;
    }

}
