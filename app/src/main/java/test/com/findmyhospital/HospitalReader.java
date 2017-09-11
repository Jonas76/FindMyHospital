package test.com.findmyhospital;


/**
 * Created by John on 10/09/2017.
 */

public class HospitalReader {

    private String OrganisationID;
    private String OrganisationCode;
    private String OrganisationType;
    private String SubType;
    private String Sector;
    private String OrganisationStatus;
    private String IsPimsManaged;
    private String OrganisationName;
    private String Address1;
    private String Address2;
    private String Address3;
    private String County;
    private String Postcode;
    private int Latitude;
    private int Longitude;
    private String ParentODSCode;
    private String ParentName;
    private int Phone;
    private String Email;
    private String Website;
    private int Fax;


    public String getOrganisationID() {
        return OrganisationID;
    }

    public void setOrganisationID(String organisationID) {
        OrganisationID = organisationID;
    }

    public String getOrganisationCode(double v) {
        return OrganisationCode;
    }

    public void setOrganisationCode(String organisationCode) {
        OrganisationCode = organisationCode;
    }

    public String getOrganisationType(String token) {
        return OrganisationType;
    }

    public void setOrganisationType(String organisationType) {
        OrganisationType = organisationType;
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String subType) {
        SubType = subType;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getOrganisationStatus() {
        return OrganisationStatus;
    }

    public void setOrganisationStatus(String organisationStatus) {
        OrganisationStatus = organisationStatus;
    }

    public String getIsPimsManaged() {
        return IsPimsManaged;
    }

    public void setIsPimsManaged(String isPimsManaged) {
        IsPimsManaged = isPimsManaged;
    }

    public String getOrganisationName() {
        return OrganisationName;
    }

    public void setOrganisationName(String organisationName) {
        OrganisationName = organisationName;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getAddress3() {
        return Address3;
    }

    public void setAddress3(String address3) {
        Address3 = address3;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public int getLatitude() {
        return Latitude;
    }

    public void setLatitude(int latitude) {
        Latitude = latitude;
    }

    public int getLongitude() {
        return Longitude;
    }

    public void setLongitude(int longitude) {
        Longitude = longitude;
    }

    public String getParentODSCode() {
        return ParentODSCode;
    }

    public void setParentODSCode(String parentODSCode) {
        ParentODSCode = parentODSCode;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public int getFax() {
        return Fax;
    }

    public void setFax(int fax) {
        Fax = fax;
    }

    @Override
    public String toString() {
        return "HospitalReader{" +
                "OrganisationID=" + OrganisationID +
                ", OrganisationCode=" + OrganisationCode +
                ", OrganisationType='" + OrganisationType + '\'' +
                ", SubType='" + SubType + '\'' +
                ", Sector='" + Sector + '\'' +
                ", OrganisationStatus='" + OrganisationStatus + '\'' +
                ", IsPimsManaged='" + IsPimsManaged + '\'' +
                ", OrganisationName='" + OrganisationName + '\'' +
                ", Address1='" + Address1 + '\'' +
                ", Address2='" + Address2 + '\'' +
                ", Address3='" + Address3 + '\'' +
                ", County='" + County + '\'' +
                ", Postcode='" + Postcode + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", ParentODSCode='" + ParentODSCode + '\'' +
                ", ParentName='" + ParentName + '\'' +
                ", Phone=" + Phone +
                ", Email='" + Email + '\'' +
                ", Website='" + Website + '\'' +
                ", Fax=" + Fax +
                '}';
    }
}


