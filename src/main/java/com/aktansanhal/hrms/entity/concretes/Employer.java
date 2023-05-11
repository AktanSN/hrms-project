package com.aktansanhal.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "website")
    @NotNull
    //@URL(host = "localhost", port = 8080)
    private String website;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "password")
    @NotNull
    @Size(min = 6)
    private String password;

    @Transient
    @JsonIgnore
    private String passwordRepeat;




    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisement;

    public Employer() {
    }

    public Employer(long id, @NotNull String companyName, @NotNull String website, @NotNull String email, @NotNull String phoneNumber, @NotNull String password, String passwordRepeat, List<JobAdvertisement> jobAdvertisement) {
        this.id = id;
        this.companyName = companyName;
        this.website = website;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.jobAdvertisement = jobAdvertisement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public List<JobAdvertisement> getJobAdvertisement() {
        return jobAdvertisement;
    }

    public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
        this.jobAdvertisement = jobAdvertisement;
    }

    /*
    public Employer() {
    }

    public Employer(@NotNull String companyName, @NotNull String website, @NotNull String email, @NotNull String phoneNumber, @NotNull String password, String passwordRepeat) {

        this.companyName = companyName;
        this.website = website;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

     */
}
