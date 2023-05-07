package com.aktansanhal.hrms.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

    // @Notblank
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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
    private String passwordRepeat;


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
