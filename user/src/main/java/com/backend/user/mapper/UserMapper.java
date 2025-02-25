package com.backend.user.mapper;

import com.backend.user.entity.ERole;
import com.backend.user.entity.Role;
import com.backend.user.entity.User;
import com.backend.userapi.model.RoleEnum;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    public User mapUserToEntity(com.backend.userapi.model.User user);
    public com.backend.userapi.model.User mapUserToModel(User user);

    public Role mapRoleToEntity(com.backend.userapi.model.Role role);
    public com.backend.userapi.model.Role mapRoleToModel(Role role);

    public ERole mapRoleEnumToModel(RoleEnum role);
    public RoleEnum mapRoleEnumToEntity(ERole role);
}
