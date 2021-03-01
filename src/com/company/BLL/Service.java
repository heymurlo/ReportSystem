package com.company.BLL;

import com.company.DAL.Employee;
import com.company.DAL.IRepository;
import com.company.DAL.ReportState;
import com.company.DAL.Task;
import com.company.DAL.Report;
import com.company.UIL.EmployeeVM;
import com.company.UIL.TaskVM;

import java.util.LinkedList;
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



    public void AddTask(TaskDTO task, int employeeId) {
        Task NewObj = new Task(task.GetName(), task.GetDescription(), task.GetId());
        TaskRepository.Create(NewObj, NewObj.GetId());
        //TaskRepository.Create(NewObj, NewObj.GetId());
        Employee employee = EmployeeRepository.Get(employeeId);
        employee.AddTask(NewObj);
    }

    //public void GetEmployeesTasks()

    /*public void AddTask(String name, String descr, int taskId, int emplId) {
        Task NewObj = new Task(name, descr, taskId);
        TaskRepository.Create(NewObj, taskId);
        Employee E = EmployeeRepository.Get(emplId);
        E.AddTask(NewObj);
    }*/

    /*public void AddEmployee(EmployeeDTO empl) {
        Employee NewObj = EmployeeRepository.Get(empl.GetId());
        EmployeeRepository.Create(NewObj, NewObj.GetId());
        // EmployeeRepository.Create(NewObj);
    }*/

    public void AddEmployee(EmployeeDTO empl, int BossId) {
        Employee NewObj = new Employee(empl.GetName(), empl.GetId());
        EmployeeRepository.Create(NewObj, NewObj.GetId());
        Employee Boss = EmployeeRepository.Get(BossId);
        NewObj.SetBoss(Boss);
        if (empl.GetId() == BossId) {
            NewObj.SetBoss(null);
        }
        if (empl.GetId() != BossId) {
            Boss.AddSubordinate(NewObj);
        }

    }

    /*public void AddReport(ReportDTO report) {
        Report NewObj = new Report(report.GetName(), report.GetId());
        ReportRepository.Create(NewObj, NewObj.GetId());
        // ReportRepository.Create(NewObj);
    }*/

    public void AddReport(ReportDTO report, EmployeeDTO empl) {
        Report NewObj = new Report(report.GetName(), report.GetId());
        ReportRepository.Create(NewObj, NewObj.GetId());
        Employee employee = EmployeeRepository.Get(empl.GetId());
        NewObj.SetResponsible(employee);

    }

    public List<TaskDTO> GetTask() {
        List<Task> Tasks = TaskRepository.GetEntities();
        List<TaskDTO> TasksDTO = new LinkedList<>();

        for (Task t : Tasks) {
            TaskDTO NewObj = new TaskDTO(t.GetName(), t.GetDescription(), t.GetId());
            TasksDTO.add(NewObj);
        }
        return TasksDTO;
    }

    public List<ReportDTO> GetReport() {
        List<Report> Reports = ReportRepository.GetEntities();
        List<ReportDTO> ReportsDTO = new LinkedList<>();

        for (Report r : Reports) {
            ReportDTO NewObj = new ReportDTO(r.GetName(), r.GetId());
            ReportsDTO.add(NewObj);
        }
        return ReportsDTO;
    }

    //NEW CODE

    public Task GetTaskById(int id) {
        return this.TaskRepository.Get(id);
    }

    public List<Employee> GetSubords(int bossId) {
        Employee boss = this.EmployeeRepository.Get(bossId);
        //System.out.println(boss.GetName());
        return boss.GetSubordinates();

    }

    public List<Task> GetTasksByEmployee(int id) {
        Employee empl = this.EmployeeRepository.Get(id);
        return empl.GetTasks();
    }

    public Employee GetMyBoss(int id) {
        Employee Boss = EmployeeRepository.Get(id);
        return Boss.GetBoss();
    }


    public void AddToReport(EmployeeDTO E, ReportDTO R) {
        Employee Boss = EmployeeRepository.Get(E.GetId());
        Report Rep = ReportRepository.Get(R.GetId());
        List<Task> l = Boss.GetTasks();
        for (Task t: l) {
            Rep.SetContent(t.GetName());
        }
    }

    public void GetSubordsTasks(int BossId) {
        List<Task> Tasks = new LinkedList<>();
        Employee Boss = EmployeeRepository.Get(BossId);
        for (Employee empl: Boss.GetSubordinates()) {
            Tasks.addAll(empl.GetTasks());
        }
        for (Task t : Tasks) {
            System.out.println(t.GetName());
        }

    }

    public void ChangeEmployee(EmployeeDTO one, EmployeeDTO another, TaskDTO task) {
        another.AddTask(task);
        one.RemoveTask(task);
    }

    public void AddComment(String Comm, TaskDTO Task) {

    }

    public String GetReportContent(ReportDTO Rep) {
        Report R = ReportRepository.Get(Rep.GetId());
        return R.GetContent();
    }

    public void CloseReport(EmployeeDTO Resp, ReportDTO Rep) {
      Report R = ReportRepository.Get(Rep.GetId());
      Employee E = EmployeeRepository.Get(Resp.GetId());
      if (E.IsBoss()) {
          R.SetStatus(ReportState.closed, E);
      }
      else System.out.println("this employee is not able to close sprint report");

    }

    public void GetHierarchy() {
        List<Employee>EmplList = EmployeeRepository.GetEntities();
        for(Employee e : EmplList) {
            List<Employee> Sub = e.GetSubordinates();
            if (e.IsBoss()) {
                for (Employee em : Sub) {
                    System.out.println("Teamlead is: " + e.GetName() + ", Subordinates: " + em.GetName());
                }
            }
            if (e.IsHead()) {
                for (Employee em : Sub) {
                    System.out.println("Head is: " + e.GetName() + ", Subordinate: " + em.GetName());
                }
            }



        }
    }

    public void ChangeBoss(EmployeeDTO E, EmployeeDTO NewBoss) {
        Employee Em = EmployeeRepository.Get(E.GetId());
        Em.SetBoss(new Employee(NewBoss.GetName(), NewBoss.GetId()));
    }

}
