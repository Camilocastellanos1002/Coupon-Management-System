package riwi.lastfilter.spring.api.dto.request;

import jakarta.persistence.Column;

public class CouponUpdateRequest {

    @Column(nullable = false)
    private String id;

}
