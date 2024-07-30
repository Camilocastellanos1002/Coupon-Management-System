package riwi.lastfilter.spring.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import riwi.lastfilter.spring.api.dto.request.UserRequest;
import riwi.lastfilter.spring.api.dto.response.UserResponse;
import riwi.lastfilter.spring.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING/*, uses = {BuysMapper.class}*/)
public interface UserMapper {

    UserResponse toDTOEntity(User user);

    
    User toEntity(UserRequest userReq);
}



