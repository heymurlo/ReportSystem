package com.company.DAL;

import com.company.DAL.ReportState;

public class Report extends IEntity{
    private String Name;
    private ReportState Status;

    public Report(String name, int id) {
        Name = name;
        Id = id;
        Status = ReportState.started;
    }
    /*void SetStatus(ReportState NewState) {
        Status = NewState;
    }*/

    void CloseReport() {
        Status = ReportState.closed;
    }

    public String GetName() {
        return Name;
    }




}
