package com.lsu.lkrf.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName package
 */
public class Package implements Serializable {
    /**
     * 
     */
    private Object id;

    /**
     * 工种、流程
     */
    private Integer product;

    /**
     * 对应package表
     */
    private Integer pac;

    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private Integer staff;

    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Object getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 工种、流程
     */
    public Integer getProduct() {
        return product;
    }

    /**
     * 工种、流程
     */
    public void setProduct(Integer product) {
        this.product = product;
    }

    /**
     * 对应package表
     */
    public Integer getPac() {
        return pac;
    }

    /**
     * 对应package表
     */
    public void setPac(Integer pac) {
        this.pac = pac;
    }

    /**
     * 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     */
    public Integer getStaff() {
        return staff;
    }

    /**
     * 
     */
    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    /**
     * 
     */
    public Date getTime() {
        return time;
    }

    /**
     * 
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Package other = (Package) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProduct() == null ? other.getProduct() == null : this.getProduct().equals(other.getProduct()))
            && (this.getPac() == null ? other.getPac() == null : this.getPac().equals(other.getPac()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getStaff() == null ? other.getStaff() == null : this.getStaff().equals(other.getStaff()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
        result = prime * result + ((getPac() == null) ? 0 : getPac().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getStaff() == null) ? 0 : getStaff().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", pac=").append(pac);
        sb.append(", state=").append(state);
        sb.append(", staff=").append(staff);
        sb.append(", time=").append(time);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}