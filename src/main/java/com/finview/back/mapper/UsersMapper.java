package com.finview.back.mapper;

import com.finview.back.model.user.User;
import com.finview.back.model.user.UserDto;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface UsersMapper {

    UserDto map(User user);

    User map(UserDto userDto);

}
