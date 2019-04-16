package tables;

public class AgencyTableObject {

    private int AgencyID;
    private String name;
    private String dateOfEstablishment;
    private String address;

    public AgencyTableObject(int agencyID, String name, String dateOfEstablishment, String address) {
        AgencyID = agencyID;
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.address = address;
    }

    public int getAgencyID() {
        return AgencyID;
    }

    public void setAgencyID(int agencyID) {
        AgencyID = agencyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(String dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
