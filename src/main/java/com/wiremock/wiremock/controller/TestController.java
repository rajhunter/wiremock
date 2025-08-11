package com.wiremock.wiremock.controller;

import com.wiremock.wiremock.bean.BeanTest;
import com.wiremock.wiremock.bean.SessionBeanScope;
import com.wiremock.wiremock.model.Employee;
import com.wiremock.wiremock.service.EmployeeService;
import com.wiremock.wiremock.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



        import com.wiremock.wiremock.bean.BeanTest;
        import com.wiremock.wiremock.bean.SessionBeanScope;
        import com.wiremock.wiremock.model.Employee;
        import com.wiremock.wiremock.service.EmployeeService;
        import com.wiremock.wiremock.service.PaymentService;
        import io.swagger.v3.oas.annotations.Parameter;
        import jakarta.annotation.PostConstruct;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import io.swagger.v3.oas.annotations.Operation;
        import io.swagger.v3.oas.annotations.responses.ApiResponse;
        import io.swagger.v3.oas.annotations.responses.ApiResponses;
        import io.swagger.v3.oas.annotations.tags.Tag;
        import io.swagger.v3.oas.annotations.parameters.RequestBody;
        import io.swagger.v3.oas.annotations.media.Content;
        import io.swagger.v3.oas.annotations.media.Schema;

        import java.util.Optional;

//@RestController
//@RequestMapping("api")
//@Tag(name = "Employee APIs", description = "Operations for managing employees")
public class TestController {

    private final PaymentService paymentClient;
    @Autowired
    BeanTest beanTest;
    @Autowired
    SessionBeanScope sessionBeanScope;
    @Autowired
    EmployeeService employeeService;

    public TestController(PaymentService paymentClient) {
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
    public Optional<Employee> addEmployee(@RequestBody Employee employee) {
        return Optional.ofNullable(employeeService.saveEmployee(employee));
    }

    @PostMapping("/add2")
    public Employee  addEmployee2(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @Operation(
            summary = "Get employee by ID",
            description = "Fetches employee details based on ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(
            @Parameter(description = "Employee ID", example = "101")
            @PathVariable Long id
    ) {
        return employeeService.getEmployee(id);
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
