package com.tudublin.apms.entity;

public class Details {
    private Long detailsId;
    private String name;
    private Long paymentId;
    private String email;
    private String phone;

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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

    @Override
    public String toString() {
        return "Details{" +
                "detailsId=" + detailsId +
                ", name='" + name + '\'' +
                ", paymentId=" + paymentId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
