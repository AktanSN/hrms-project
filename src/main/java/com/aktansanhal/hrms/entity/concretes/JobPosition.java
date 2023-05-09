package com.aktansanhal.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name = "job_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class JobPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "position_name")
    @NotNull
    private String positionName;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    @JsonIgnore
    private Employer employer;


    /*
    public JobPosition() {
    }

    public JobPosition(@NotNull String positionName) {
        this.positionName = positionName;
    }

     */
}
