package com.trilogyed.hotelbookingservice.model;


public class Rewards {

    private Integer id;
    private String roomType;
    private Float discount;
    private Integer points;
    private Boolean canDouble;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }
}
