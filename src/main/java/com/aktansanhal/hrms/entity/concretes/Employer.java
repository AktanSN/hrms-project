package com.aktansanhal.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
