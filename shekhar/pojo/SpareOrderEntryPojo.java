/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.pojo;

/**
 *
 * @author Rohit
 */
public class SpareOrderEntryPojo {
    
    private int orderid;
    private int spareid;
    private String quantity;
    private String rate;
    private String total;

    /**
     * @return the orderid
     */
    public int getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the spareid
     */
    public int getSpareid() {
        return spareid;
    }

    /**
     * @param spareid the spareid to set
     */
    public void setSpareid(int spareid) {
        this.spareid = spareid;
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
    
    
    
}
