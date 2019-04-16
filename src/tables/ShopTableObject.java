package tables;

public class ShopTableObject {

    private int ShopID;
    private int numberOfAgencies;
    private String name;
    private String dateOfEstablishment;
    private String surface;


    public ShopTableObject(int shopID, String name, int numberOfAgencies, String dateOfEstablishment, String surface) {
        ShopID = shopID;
        this.numberOfAgencies = numberOfAgencies;
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.surface = surface;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
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

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getNumberOfAgencies() {
        return numberOfAgencies;
    }

    public void setNumberOfAgencies(int numberOfAgencies) {
        this.numberOfAgencies = numberOfAgencies;
    }
}
