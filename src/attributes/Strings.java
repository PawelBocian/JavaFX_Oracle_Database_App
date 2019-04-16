package attributes;

public class Strings {
/**
 * App data
 */
public static final String APP_NAME = "Shop data manager";
public static final String ICON_PATH = "ress/database_icon.png";
    /**
 * User account data
 */
public static final String ADMIN_LOGIN = "admin";
public static final String ADMIN_PASSWORD = "123";
public static final String USER_LOGIN = "user";
public static final String USER_PASSWORD = "321";

    /**
 * Paths to samples
 */
public static final String LOGIN_SAMPLE = "./sample/sampleLogin.fxml";
public static final String ADMIN_SAMPLE = "sample/admin/sampleAdmin_Main_Menu.fxml";
public static final String EMPLOYEE_SAMPLE = "sample/admin/sampleAdmin_Employees.fxml";
public static final String SHOP_SAMPLE = "sample/admin/sampleAdmin_Shops.fxml";
public static final String AGENCY_SAMPLE = "sample/admin/sampleAdmin_Agencies.fxml";
public static final String ADD_EMPLOYEE_SAMPLE = "./sample/admin/sampleAdmin_Add_Employee.fxml";
public static final String USER_SAMPLE = "sample/user/sampleUser_Main_Menu.fxml";
public static final String USER_SHOP_SAMPLE = "./sample/user/sampleUser_Shops.fxml";
public static final String USER_AGENCY_SAMPLE = "./sample/user/sampleUser_Agencies.fxml";
public static final String USER_EMPLOYEE_SAMPLE = "./sample/user/sampleUser_Employees.fxml";


/**
 * SQL requests
 */

public static final String GET_EMPLOYEE = "SELECT EMPLOYEES.EmployeeID, EMPLOYEES.NAME, EMPLOYEES.SURNAME, EMPLOYEES.DATEOFEMPLOYMENT, EMPLOYEES.GENDER, EMPLOYEES.PESEL, A.STREET, A.HOMENUMBER, A.APARTMENTNUMBER, A.COUNTRY, A.POSTCODE, A.COUNTRY ,J.name as JOBNAME from Employees\n"+
                                          "inner join Addresses A\n" +
                                          "on employees.addressid = A.addressid\n" +
                                          "inner join JobTitles J\n" +
                                          "on employees.jobtitleid = J.JobTitleID";

public static final String GET_SHOPS = "select SHOPS.SHOPID, SHOPS.NAME, SHOPS.DATEOFESTABLISHMENT, SHOPS.SURFACE from shops";

public static final String GET_AGENCIES = "select agencies.AGENCYID, agencies.AGENCYDATEOFESTABLISHMENT, S.NAME as NAME, A.POSTCODE, A.STREET , A.HOMENUMBER , A.APARTMENTNuMBER , A.COUNTRY  from agencies\n" +
                                          "inner join Shops S\n" +
                                          "on agencies.shopid = S.shopID\n" +
                                          "inner join Addresses A\n" +
                                          "on agencies.addressid = A.addressID";

public static final String GET_NUMBER_OF_AGENCIES = "select COUNT(shopid) as Liczba\n" +
                                                    "from agencies\n" +
                                                    "where agencies.shopid = ";

public static final String REMOVE_EMPLOYEE_BY_ID = "DELETE FROM Employees WHERE EmployeeID = ";

public static final String REMOVE_AGENCY_BY_ID = "DELETE FROM AGENCIES WHERE AGENCYID = ";

public static final String REMOVE_SHOP_BY_ID = "DELETE FROM SHOPS WHERE SHOPID = ";

}
