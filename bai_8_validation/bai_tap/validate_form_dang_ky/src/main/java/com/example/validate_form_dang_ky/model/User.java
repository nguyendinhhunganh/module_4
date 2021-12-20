package com.example.validate_form_dang_ky.model;


import javax.validation.constraints.*;

public class User {
    @Size(min = 5,max = 45, message = "Độ dài phải lớn hơn 5 và bé hơn 46 kí tự")
    private String firstName;
    @Size(min = 5,max = 45, message = "Độ dài phải lớn hơn 5 và bé hơn 46 kí tự")
    private String lastName;
    @Size(min = 10, max = 11, message = "Số điện thoại có độ dài 10 hoặc 12 số")
    @Pattern(regexp = "(^[0][0-9]+$)",message = "Số không đúng định dạng")
    private String phoneNumber;
    @Email
    private String email;

    public User() {
    }

    public User(String firstName,String lastName,String phoneNumber,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
