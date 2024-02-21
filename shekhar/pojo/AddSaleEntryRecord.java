/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.pojo;

/**
 *
 * @author Rohit
 */
public class AddSaleEntryRecord {
    private int orderID;
    private int productID;
    private String quantity;
    private String rate;
    private String total;
    private String warrentyUpto;

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the wareentyUpto
     */
    public String getWarrentyUpto() {
        return warrentyUpto;
    }

    /**
     * @param wareentyUpto the wareentyUpto to set
     */
    public void setWarrentyUpto(String warrentyUpto) {
        this.warrentyUpto = warrentyUpto;
    }
    
}
