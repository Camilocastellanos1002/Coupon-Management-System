package riwi.lastfilter.spring.api.controllers;

import java.util.Optional;

import org.hibernate.query.Page;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import riwi.lastfilter.spring.api.dto.response.CouponResponse;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.interface_services.ICouponService;

@RestController
@RequestMapping(path = "coupons")
@AllArgsConstructor
public class CouponController {
    
    @Autowired
    private final ICouponService couponService;
    /*----------------------
     * GET ALL ROLES
     * ---------------------
     */
    // SWAGGER
    @Operation(
    summary = "Get all coupons", 
    description = "Retrieve a paginated list of all coupons", 
    parameters = {
        @Parameter(name = "page", 
                   description = "Page number", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "1")),
        @Parameter(name = "size", 
                   description = "Page size", 
                   schema = @Schema(
                    type = "integer", 
                    defaultValue = "10")),
        @Parameter(name = "sort", 
                   description = "Sort criteria", 
                   array = @ArraySchema(
                    schema = @Schema(
                        type = "string", 
                        defaultValue = "status", 
                        allowableValues = {"id", "name", "description", "status"})))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<org.springframework.data.domain.Page<CouponResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "status") Pageable pageable) {
        Page<CouponResponse> responses = this.couponService.getAll(pageable);
        return ResponseEntity.ok(responses);
    }

    /*--------------------
     * GET BY ID
     * -------------------
     */

    @Operation(summary = "Get coupon by ID", description = "Retrieves a coupon by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CouponResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.find(id));
    }

    

    /*----------------------
     * DELETE ROLE (DISABLE ROLE - SOFT DELETE)
     * ---------------------
     */

    @Operation(summary = "Disable coupon by ID", description = "Disables a previously created coupon identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    
}
