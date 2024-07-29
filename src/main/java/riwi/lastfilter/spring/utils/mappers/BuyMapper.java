package riwi.lastfilter.spring.utils.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import riwi.lastfilter.spring.api.dto.request.BuyRequest;
import riwi.lastfilter.spring.api.dto.response.BuyResponse;
import riwi.lastfilter.spring.domain.entities.Buy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuyMapper {
    
    BuyResponse toDTOEntity(Buy buy);

    @InheritInverseConfiguration(name = "toDTOEntity")
    Buy toEntity(BuyRequest buyRequest);
}
