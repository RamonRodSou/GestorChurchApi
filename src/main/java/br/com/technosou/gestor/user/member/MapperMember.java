package br.com.technosou.gestor.user.member;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import br.com.technosou.gestor.user.child.Child;
import br.com.technosou.gestor.user.child.ChildSummary;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperMember {

    MapperMember INSTANCE = Mappers.getMapper(MapperMember.class);

    MemberResponse toResponse(Member member);

    Member toEntity(MemberRequest request);

    ChildSummary toChildSummary(Child child);

    List<ChildSummary> toChildSummaryList(List<Child> childList);

}
