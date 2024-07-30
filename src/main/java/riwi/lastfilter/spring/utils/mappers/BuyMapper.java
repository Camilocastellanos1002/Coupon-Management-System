package riwi.lastfilter.spring.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import riwi.lastfilter.spring.api.dto.request.BuyRequest;
import riwi.lastfilter.spring.api.dto.response.BuyResponse;
import riwi.lastfilter.spring.domain.entities.Buy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuyMapper {
    
    BuyResponse toDTOEntity(Buy buy);

    @Mappings({
        @Mapping(source = "couponId", target = "coupon.id"),
        @Mapping(source = "userId", target = "user.id"),
        @Mapping(source = "productId", target = "product.id"),
        @Mapping(target = "id", ignore = true)
    })
    Buy toEntity(BuyRequest buyRequest);
}
