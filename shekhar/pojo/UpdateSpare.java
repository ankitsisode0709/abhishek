/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.pojo;

/**
 *
 * @author Horten
 */
public class UpdateSpare {
   private Integer SpareId;
    private String SpareName;
    private String SpareCost;
    private String SpareDescription;
    private String SpareCompony;
    private String SpareWarrontyDate;
    private String SpareType;
   

    /**
     * @return the SpareName
     */
    public String getSpareName() {
        return SpareName;
    }

    /**
     * @param SpareName the SpareName to set
     */
    public void setSpareName(String SpareName) {
        this.SpareName = SpareName;
    }

    /**
     * @return the SpareCost
     */
    public String getSpareCost() {
        return SpareCost;
    }

    /**
     * @param SpareCost the SpareCost to set
     */
    public void setSpareCost(String SpareCost) {
        this.SpareCost = SpareCost;
    }

    /**
     * @return the SpareDescription
     */
    public String getSpareDescription() {
        return SpareDescription;
    }

    /**
     * @param SpareDescription the SpareDescription to set
     */
    public void setSpareDescription(String SpareDescription) {
        this.SpareDescription = SpareDescription;
    }

    /**
     * @return the SpareCompony
     */
    public String getSpareCompony() {
        return SpareCompony;
    }

    /**
     * @param SpareCompony the SpareCompony to set
     */
    public void setSpareCompony(String SpareCompony) {
        this.SpareCompony = SpareCompony;
    }

    /**
     * @return the SpareWarrontyDate
     */
    public String getSpareWarrontyDate() {
        return SpareWarrontyDate;
    }

    /**
     * @param SpareWarrontyDate the SpareWarrontyDate to set
     */
    public void setSpareWarrontyDate(String SpareWarrontyDate) {
        this.SpareWarrontyDate = SpareWarrontyDate;
    }

    /**
     * @return the SpareId
     */
    public Integer getSpareId() {
        return SpareId;
    }

    /**
     * @param SpareId the SpareId to set
     */
    public void setSpareId(Integer SpareId) {
        this.SpareId = SpareId;
    }

    /**
     * @return the SpareType
     */
    public String getSpareType() {
        return SpareType;
    }

    /**
     * @param SpareType the SpareType to set
     */
    public void setSpareType(String SpareType) {
        this.SpareType = SpareType;
    }
}
