package com.aktansanhal.hrms.entity.concretes;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "job_positions")
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

    public JobPosition(long id, @NotNull String positionName) {
        this.id = id;
        this.positionName = positionName;
    }
}
