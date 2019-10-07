package main.java.hotelbookingservice.model;

import java.util.Objects;

public class BookingViewModel {

 private int  roomNumber;
 private String roomType;
 private boolean rewardsMember;
 private boolean doubleBonusDay;
 private double baseRate;
 private float memberDiscount;
 private int baseRewardsPoints;
 private boolean canDouble;
 private double finalCost;
 private int totalRewardsPoints;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public boolean isDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public int getBaseRewardsPoints() {
        return baseRewardsPoints;
    }

    public void setBaseRewardsPoints(int baseRewardsPoints) {
        this.baseRewardsPoints = baseRewardsPoints;
    }

    public boolean isCanDouble() {
        return canDouble;
    }

    public void setCanDouble(boolean canDouble) {
        this.canDouble = canDouble;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public int getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(int totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingViewModel that = (BookingViewModel) o;
        return roomNumber == that.roomNumber &&
                rewardsMember == that.rewardsMember &&
                doubleBonusDay == that.doubleBonusDay &&
                Double.compare(that.baseRate, baseRate) == 0 &&
                Float.compare(that.memberDiscount, memberDiscount) == 0 &&
                baseRewardsPoints == that.baseRewardsPoints &&
                canDouble == that.canDouble &&
                Double.compare(that.finalCost, finalCost) == 0 &&
                totalRewardsPoints == that.totalRewardsPoints &&
                Objects.equals(roomType, that.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, rewardsMember, doubleBonusDay, baseRate, memberDiscount, baseRewardsPoints, canDouble, finalCost, totalRewardsPoints);
    }
}
