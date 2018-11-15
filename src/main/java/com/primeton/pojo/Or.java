package com.primeton.pojo;

import java.io.Serializable;

public class Or implements Serializable {
    private Integer orId;

    private String orName;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName == null ? null : orName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orId=").append(orId);
        sb.append(", orName=").append(orName);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
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
        Or other = (Or) that;
        return (this.getOrId() == null ? other.getOrId() == null : this.getOrId().equals(other.getOrId()))
            && (this.getOrName() == null ? other.getOrName() == null : this.getOrName().equals(other.getOrName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrId() == null) ? 0 : getOrId().hashCode());
        result = prime * result + ((getOrName() == null) ? 0 : getOrName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}