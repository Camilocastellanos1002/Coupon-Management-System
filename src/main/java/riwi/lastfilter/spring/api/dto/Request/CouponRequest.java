package riwi.lastfilter.spring.api.dto.Request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.lastfilter.spring.utils.enums.StateType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequest {

    private Long id;
    private LocalDateTime expirationDate;
    private double discountPercent;
    private StateType state;

}
