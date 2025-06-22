package user.member;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperMember {

    MapperMember INSTANCE = Mappers.getMapper(MapperMember.class);

    Member toEntity(MemberRequest request);
    MemberResponse toResponse(Member member);
}
