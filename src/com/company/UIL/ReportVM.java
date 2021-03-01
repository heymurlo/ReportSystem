package com.company.UIL;
import com.company.BLL.EmployeeDTO;
import com.company.DAL.Report;
import com.company.DAL.ReportState;

public class ReportVM {
    private int Id;
    private String Name;
    private String Content;
    private int ResponsibleId;
    // private EmployeeVM Responsible;
    private ReportState Status;

    public ReportVM(String name, int id) {
        Name = name;
        //Content = content;
        Id = id;
        //ResponsibleId = RId;
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

    public void Close(EmployeeVM Responsible) {
        Status = ReportState.closed;
    }


  /*  public void SetResponsible(EmployeeVM responsible) {
        Responsible = responsible;
    }

     public EmployeeVM GetResponsible() {
        return Responsible;
    }*/




}
