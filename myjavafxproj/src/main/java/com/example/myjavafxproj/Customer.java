package com.example.myjavafxproj;

public class Customer {

    private String orderDate;
    private String region;
    private String rep1;
    private String rep2;
    private String item;
    private Float unit;
    private Float cost;
    private Float total;

    public Customer() {
    }

    public Customer(String orderDate, String region, String rep1, String rep2, String item, Float unit, Float cost, Float total) {
        this.orderDate = orderDate;
        this.region = region;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.item = item;
        this.unit = unit;
        this.cost = cost;
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getUnit() {
        return unit;
    }
    //Konverterar till float här i klassen istället så jag slipper göra det på 2 platser i koden
    public void setUnit(String unit) {
        try {
            this.unit = Float.parseFloat(unit);
        } catch (Exception e) {
            this.unit = Float.parseFloat("0");
        }
    }

    public Float getCost() {
        return cost;
    }
    //Samma som ovanför
    public void setCost(String cost) {
        try {
            this.cost = Float.parseFloat(cost);
        } catch (Exception e) {
            this.cost = Float.parseFloat("0");
        }
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
