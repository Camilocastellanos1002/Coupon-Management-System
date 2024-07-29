package riwi.lastfilter.spring.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.lastfilter.spring.api.dto.Response.UserResponse;
import riwi.lastfilter.spring.domain.entities.Coupon;
import riwi.lastfilter.spring.domain.entities.Product;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyResponse {
    
    @Schema(description = "Buy ID", example = "1212211545")
    private Long id;

    @Schema(description = "Coupon information")
    private Coupon coupon;

    @Schema(description = "User information")
    private UserResponse user;

    @Schema(description = "Product information")
    private Product product;
}