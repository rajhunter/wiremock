package com.wiremock.wiremock.controller;

import com.wiremock.wiremock.bean.BeanTest;
import com.wiremock.wiremock.bean.SessionBeanScope;
import com.wiremock.wiremock.model.Employee;
import com.wiremock.wiremock.service.EmployeeService;
import com.wiremock.wiremock.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Tag(name = "Employee APIs", description = "Operations for managing employees")
public class Controller {

    private final PaymentService paymentClient;
    @Autowired
    BeanTest beanTest;
    @Autowired
    SessionBeanScope sessionBeanScope;
    @Autowired
    EmployeeService employeeService;

    public Controller(PaymentService paymentClient) {
        this.paymentClient = paymentClient;
    }
    @Operation(
            summary = "Add a new employee",
            description = "Creates and returns the saved employee",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Employee object to be added",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Employee.class))
            )
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/pay")
    public String makePayment() {
        // return "test";

        return paymentClient.processPayment();
    }

    @GetMapping("/")
    public String home() {
        beanTest.getClass();
        return sessionBeanScope.msg();
        // return "Hello, Spring Boot!";
    }

    @PostConstruct
    public void init() {
        System.out.println("Controller initialized ✅");
    }


    public void streamAPI() {


    }
}
