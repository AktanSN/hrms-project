package com.aktansanhal.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class JobPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "position_name")
    @NotNull
    private String positionName;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    @JsonIgnore
    private Employer employer;

    public JobPosition() {
    }

    public JobPosition(Long id, @NotNull String positionName, Employer employer) {
        this.id = id;
        this.positionName = positionName;
        this.employer = employer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    /*
    public JobPosition() {
    }

    public JobPosition(@NotNull String positionName) {
        this.positionName = positionName;
    }

     */
}
