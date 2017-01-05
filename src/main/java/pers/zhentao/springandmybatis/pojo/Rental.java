package pers.zhentao.springandmybatis.pojo;

import java.util.Date;

public class Rental {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.rental_id
     *
     * @mbggenerated
     */
    private Integer rentalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.rental_date
     *
     * @mbggenerated
     */
    private Date rentalDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.inventory_id
     *
     * @mbggenerated
     */
    private Integer inventoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.customer_id
     *
     * @mbggenerated
     */
    private Short customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.return_date
     *
     * @mbggenerated
     */
    private Date returnDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.staff_id
     *
     * @mbggenerated
     */
    private Byte staffId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rental.last_update
     *
     * @mbggenerated
     */
    private Date lastUpdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.rental_id
     *
     * @return the value of rental.rental_id
     *
     * @mbggenerated
     */
    public Integer getRentalId() {
        return rentalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.rental_id
     *
     * @param rentalId the value for rental.rental_id
     *
     * @mbggenerated
     */
    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.rental_date
     *
     * @return the value of rental.rental_date
     *
     * @mbggenerated
     */
    public Date getRentalDate() {
        return rentalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.rental_date
     *
     * @param rentalDate the value for rental.rental_date
     *
     * @mbggenerated
     */
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.inventory_id
     *
     * @return the value of rental.inventory_id
     *
     * @mbggenerated
     */
    public Integer getInventoryId() {
        return inventoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.inventory_id
     *
     * @param inventoryId the value for rental.inventory_id
     *
     * @mbggenerated
     */
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.customer_id
     *
     * @return the value of rental.customer_id
     *
     * @mbggenerated
     */
    public Short getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.customer_id
     *
     * @param customerId the value for rental.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.return_date
     *
     * @return the value of rental.return_date
     *
     * @mbggenerated
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.return_date
     *
     * @param returnDate the value for rental.return_date
     *
     * @mbggenerated
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.staff_id
     *
     * @return the value of rental.staff_id
     *
     * @mbggenerated
     */
    public Byte getStaffId() {
        return staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.staff_id
     *
     * @param staffId the value for rental.staff_id
     *
     * @mbggenerated
     */
    public void setStaffId(Byte staffId) {
        this.staffId = staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rental.last_update
     *
     * @return the value of rental.last_update
     *
     * @mbggenerated
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rental.last_update
     *
     * @param lastUpdate the value for rental.last_update
     *
     * @mbggenerated
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}