package com.example;

public class Record {
    private int sno;
    private String name;
    private int purchase;
    private String email;
    private String phone;

    public Record(int sno, String name, int purchase, String email, String phone) {
        this.sno = sno;
        this.name = name;
        this.purchase = purchase;
        this.email = email;
        this.phone = phone;
    }

    public Record() {
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
