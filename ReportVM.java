package com.company.UIL;
import com.company.BLL.EmployeeDTO;
import com.company.DAL.Report;
import com.company.DAL.ReportState;

public class ReportVM {
    private int Id;
    private String Name;
    private String Content;
    private EmployeeVM Responsible;
    private ReportState Status;

    public ReportVM(String name, String content, int id, EmployeeVM empl) {
        Name = name;
        Content = content;
        Id = id;
        Responsible = empl;
        Status = ReportState.started;
    }

    public int GetId() {
        return Id;
    }

    public String GetName() {
        return Name;
    }

    public void AddContent(String content) {
        Content = content;
    }

    public String GetContent() {
        return Content;
    }


         public void SetResponsible(EmployeeVM responsible) {
        Responsible = responsible;
    }

     public EmployeeVM GetResponsible() {
        return Responsible;
    }




}
