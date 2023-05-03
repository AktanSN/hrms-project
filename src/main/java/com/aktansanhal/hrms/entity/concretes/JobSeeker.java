package com.aktansanhal.hrms.entity.concretes;

import jakarta.persistence.*;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "job_seekers")
@Data
public class JobSeeker {

    // @Notblank
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "national_id")
    @NotNull
    private String nationalNumber;

    @Column(name = "date_of_birth")
    @NotNull
    private LocalDate birthYear;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 6)
    private String password;

    @Transient
    private String passwordRepeat;

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
}
