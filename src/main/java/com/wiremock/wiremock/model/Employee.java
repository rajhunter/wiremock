package com.wiremock.wiremock.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor // required for deserialization
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private Date dateOfBirth;
    private String location;
    private String contactNumber;
    private BigDecimal salary;
    private String dgrad;
    private String department;
    @Column(name = "date_of_join")
    private java.time.LocalDate dateOfJoin;
    // Getters & setters
}
