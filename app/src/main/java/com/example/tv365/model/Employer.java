package com.example.tv365.model;

public class Employer {
    private int empID;
    private String empLogo;
    private String empName;

    public Employer(int empID, String empLogo, String empName) {
        this.empID = empID;
        this.empLogo = empLogo;
        this.empName = empName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpLogo() {
        return empLogo;
    }

    public void setEmpLogo(String empLogo) {
        this.empLogo = empLogo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
