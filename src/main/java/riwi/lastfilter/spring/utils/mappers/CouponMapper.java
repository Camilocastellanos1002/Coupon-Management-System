package riwi.lastfilter.spring.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import riwi.lastfilter.spring.api.dto.Response.CouponResponse;
import riwi.lastfilter.spring.api.dto.request.CouponRequest;
import riwi.lastfilter.spring.domain.entities.Coupon;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CouponMapper {

    CouponResponse toGetResp (Coupon coupon);
    
    CouponRequest toGetReq(Coupon coupon);

    @Mapping(target = "buys", ignore = true)
    Coupon toGetEntity(CouponRequest request);
}
