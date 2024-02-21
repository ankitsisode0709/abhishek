/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.pojo;

/**
 *
 * @author Horten
 */
public class UpdateComplain {

    private Integer ComplainId;
    private String ComplainDescription;
    private String ComplainDate;
    private String ComplainTime;
    private String ComplainStatus;
    private Integer CustomerId;

    /**
     * @return the ComplainId
     */
    public Integer getComplainId() {
        return ComplainId;
    }

    /**
     * @param ComplainId the ComplainId to set
     */
    public void setComplainId(Integer ComplainId) {
        this.ComplainId = ComplainId;
    }

    /**
     * @return the ComplainDescription
     */
    public String getComplainDescription() {
        return ComplainDescription;
    }

    /**
     * @param ComplainDescription the ComplainDescription to set
     */
    public void setComplainDescription(String ComplainDescription) {
        this.ComplainDescription = ComplainDescription;
    }

    /**
     * @return the ComplainDate
     */
    public String getComplainDate() {
        return ComplainDate;
    }

    /**
     * @param ComplainDate the ComplainDate to set
     */
    public void setComplainDate(String ComplainDate) {
        this.ComplainDate = ComplainDate;
    }

    /**
     * @return the ComplainTime
     */
    public String getComplainTime() {
        return ComplainTime;
    }

    /**
     * @param ComplainTime the ComplainTime to set
     */
    public void setComplainTime(String ComplainTime) {
        this.ComplainTime = ComplainTime;
    }

    /**
     * @return the ComplainStatus
     */
    public String getComplainStatus() {
        return ComplainStatus;
    }

    /**
     * @param ComplainStatus the ComplainStatus to set
     */
    public void setComplainStatus(String ComplainStatus) {
        this.ComplainStatus = ComplainStatus;
    }

    /**
     * @return the CustomerId
     */
    public Integer getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(Integer CustomerId) {
        this.CustomerId = CustomerId;
    }
}
