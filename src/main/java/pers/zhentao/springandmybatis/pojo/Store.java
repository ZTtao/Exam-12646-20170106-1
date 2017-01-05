package pers.zhentao.springandmybatis.pojo;

import java.util.Date;

public class Store {
    private Integer storeId;
    private Integer managerStaffId;
    private Staff managerStaff;
    private Integer addressId;
    private Date lastUpdate;
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getManagerStaffId() {
		return managerStaffId;
	}
	public void setManagerStaffId(Integer managerStaffId) {
		this.managerStaffId = managerStaffId;
	}
	public Staff getManagerStaff() {
		return managerStaff;
	}
	public void setManagerStaff(Staff managerStaff) {
		this.managerStaff = managerStaff;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
    
}