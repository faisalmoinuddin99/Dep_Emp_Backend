package com.kakashi.departmentservice.model;

public record Employee(Long employeeId, Long departmentId, String employeeName, int age, String position) {
}
