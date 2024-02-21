/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.pojo;

/**
 *
 * @author Horten
 */
public class UpdateCustomer {
    //cid,cname,caddress,ccontact,cemail,cproductid
    private Integer CustomerID;
    private String  CustomerName;
    private String  CustomerAddress;
    private String  CustomerContact;
    private String  CustomerEmailid;
    private Integer CustomerProductId;

    /**
     * @return the CustomerID
     */
    public Integer getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(Integer CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the CustomerName
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * @param CustomerName the CustomerName to set
     */
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    /**
     * @return the CustomerAddress
     */
    public String getCustomerAddress() {
        return CustomerAddress;
    }

    /**
     * @param CustomerAddress the CustomerAddress to set
     */
    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    /**
     * @return the CustomerContact
     */
    public String getCustomerContact() {
        return CustomerContact;
    }

    /**
     * @param CustomerContact the CustomerContact to set
     */
    public void setCustomerContact(String CustomerContact) {
        this.CustomerContact = CustomerContact;
    }

    /**
     * @return the CustomerEmailid
     */
    public String getCustomerEmailid() {
        return CustomerEmailid;
    }

    /**
     * @param CustomerEmailid the CustomerEmailid to set
     */
    public void setCustomerEmailid(String CustomerEmailid) {
        this.CustomerEmailid = CustomerEmailid;
    }

    /**
     * @return the CustomerProductId
     */
    public Integer getCustomerProductId() {
        return CustomerProductId;
    }

    /**
     * @param CustomerProductId the CustomerProductId to set
     */
    public void setCustomerProductId(Integer CustomerProductId) {
        this.CustomerProductId = CustomerProductId;
    }
}
