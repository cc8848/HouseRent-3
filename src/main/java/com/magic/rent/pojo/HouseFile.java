package com.magic.rent.pojo;

public class HouseFile {
    private Integer id;

    private Integer houseId;

    private String fileName;

    private String nickName;

    private Integer viewMode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getViewMode() {
        return viewMode;
    }

    public void setViewMode(Integer viewMode) {
        this.viewMode = viewMode;
    }
}