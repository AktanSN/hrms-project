package com.aktansanhal.hrms.entity.concretes;

import jakarta.persistence.*;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "job_positions")
@Data
public class JobPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "position_name")
    @NotNull
    private String positionName;

    public JobPosition() {
    }

    public JobPosition(@NotNull String positionName) {
        this.positionName = positionName;
    }
}
