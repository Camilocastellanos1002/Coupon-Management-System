package riwi.lastfilter.spring.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import riwi.lastfilter.spring.domain.entities.Buy;
import riwi.lastfilter.spring.infrastructure.abstrasct_services.interface_services.IBuyService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/buys")
public class BuyController {
    
    @Autowired
    private final IBuyService buyService;

    // Obtener todo 
    @GetMapping
        @Operation(summary = "List all buys",
                description = "Returns a paginated list of all buys.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Returns the paginated list of buys."),
            @ApiResponse(responseCode = "400", description = "Bad request. This may occur if the parameters are incorrect.")
    })
    public ResponseEntity<Page<Buy>> getAllBuy(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pagination = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(this.buyService.findAll(pagination));
    }
}