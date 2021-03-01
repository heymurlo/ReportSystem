package com.company.BLL;

import com.company.DAL.IEntity;

public class ReportDTO extends IEntity {
    int Id ;
    private String Name;
    protected ReportState Status;
    protected EmployeeDTO Responsible;
    protected String Content;

    public ReportDTO(String name, int id) {
        Name = name;
        Id = id;
        Status = ReportState.started;
    }

    void CloseReport() {
        Status = ReportState.closed;
    }

    public String GetName() {
        return Name;
    }

    public void AddContent(String Cntnt) {
        Content = Cntnt;
    }

    public String GetContent() {
        return Content;
    }

    public EmployeeDTO GetResponsible() {
        return Responsible;
    }

@Override
    public int GetId() {
        return Id;
    }
}

