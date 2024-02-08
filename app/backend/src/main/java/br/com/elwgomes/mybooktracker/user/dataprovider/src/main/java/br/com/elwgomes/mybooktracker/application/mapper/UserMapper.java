package br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.mapper;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;
import br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDomain toDomain (UserEntity persistence);
    UserEntity toPersistence (UserDomain domain);
}
