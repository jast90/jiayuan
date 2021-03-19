package io.github.jast90.resource.entity;

import io.github.jast90.common.entity.BaseEntity;

/**
 * Created by jast90 on 2021/3/16
 */
public class House extends BaseEntity {
    private String buildingNo;
    private String houseNo;
    private String houseType;
    private String remark;
    private String houseName;

    private byte status;

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHouseName() {
        return String.format("%s %s %s",getBuildingNo(),getHouseNo(),getHouseType());
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
