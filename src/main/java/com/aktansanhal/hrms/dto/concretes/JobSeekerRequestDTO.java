package com.aktansanhal.hrms.dto.concretes;

public record JobSeekerRequestDTO(String firstName, String lastName, Long nationalNumber, int birthYear, String email, String password, String passwordRepeat, String jobPosition) {
}
