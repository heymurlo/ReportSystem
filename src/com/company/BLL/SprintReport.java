package com.company.BLL;

public class SprintReport extends ReportDTO {

    public SprintReport(String name, int id) {
        super(name, id);
    }

    public void SetTeamlead(EmployeeDTO empl) {
        if (empl.IsBoss()) {
            Responsible = empl;
        }
        else System.out.println("Only teamlead can be responsible for sprint report");
    }

    @Override
    public void AddContent(String contnet) {
        if (Status == ReportState.closed) {
            System.out.println("Error: report is closed");
        }
    }


}


