package tables;

public class EmployeeTableObject {

    private int EmployeeID;
    private String name;
    private String surname;
    private String dateOfEmployment;
    private String gender;
    private String pesel;
    private String address;
    private String jobTitle;

    public EmployeeTableObject(int employeeID, String name, String surname, String dateOfEmployment, String gender, String pesel, String address, String jobTitle) {
        EmployeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.dateOfEmployment = dateOfEmployment;
        this.gender = gender;
        this.pesel = pesel;
        this.address = address;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
