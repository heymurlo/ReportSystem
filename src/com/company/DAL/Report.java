package com.company.DAL;

import java.util.Date;

public class Report extends IEntity{
    protected String Name;
    protected ReportState Status;
    protected Employee Teamlead;
    protected String Content;
    protected Date date;

    public Report(String name, int id) {
        Name = name;
        Id = id;
        Status = ReportState.started;
    }
    public void SetStatus(ReportState NewState, Employee E) {
        Status = NewState;
    }
@Override
    public int GetId() {
        return Id;
    }
    void CloseReport() {
        Status = ReportState.closed;
    }

    public String GetName() {
        return Name;
    }

    public void SetResponsible(Employee em) {
    this.Teamlead = em;
    }

    public void SetContent(String NewContent) {
    this.Content += NewContent;
    }

    public String GetContent() {
    return Content;
    }

    public int GetDay() {
    return date.getDay();
    }



}
