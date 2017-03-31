package dvdrental;
// Generated Mar 31, 2017 11:53:24 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Store generated by hbm2java
 */
public class Store  implements java.io.Serializable {


     private Byte storeId;
     private Address address;
     private Staff staff;
     private Date lastUpdate;
     private Set<Staff> staffs = new HashSet<Staff>(0);

    public Store() {
    }

	
    public Store(Address address, Staff staff, Date lastUpdate) {
        this.address = address;
        this.staff = staff;
        this.lastUpdate = lastUpdate;
    }
    public Store(Address address, Staff staff, Date lastUpdate, Set<Staff> staffs) {
       this.address = address;
       this.staff = staff;
       this.lastUpdate = lastUpdate;
       this.staffs = staffs;
    }
   
    public Byte getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set<Staff> getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }




}


