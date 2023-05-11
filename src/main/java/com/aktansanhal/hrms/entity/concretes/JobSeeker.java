package com.aktansanhal.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "job_seekers")
public class JobSeeker {

    // @Notblank
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "national_id")
    @NotBlank
    private Long nationalNumber;

    @Column(name = "date_of_birth")
    @NotBlank
    private int birthYear;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "password")
    @NotBlank
    @Size(min = 6)
    private String password;

    @Transient
    @JsonIgnore
    private String passwordRepeat;

    @Column(name = "job_position")
    private String jobPosition;

    public JobSeeker() {
    }

    public JobSeeker(Long id, String firstName, String lastName, Long nationalNumber, int birthYear, String email, String password, String passwordRepeat, String jobPosition) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalNumber = nationalNumber;
        this.birthYear = birthYear;
        this.email = email;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.jobPosition = jobPosition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(Long nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    /*
    public JobSeeker() {
    }

    public JobSeeker(@NotNull String firstName, @NotNull String lastName, @NotNull String nationalNumber, @NotNull LocalDate birthYear, @NotNull String email, @NotNull String password, String passwordRepeat) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalNumber = nationalNumber;
        this.birthYear = birthYear;
        this.email = email;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }
     */
}
