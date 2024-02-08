package br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.mapper;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;
import br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserHttpMapper {
    UserHttpMapper INSTANCE = Mappers.getMapper(UserHttpMapper.class);
    UserDomain toDomain(UserRequest request);
}
