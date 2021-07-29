package com.dev.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.dev.server.dto.MemberDto;
import com.dev.server.model.Member;

@Mapper(componentModel = "spring",
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MemberMapper {
	
	MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
	
	@Mapping(target = "createdTimeAt", ignore = true)
	@Mapping(target = "isMember", ignore = true)
	@Mapping(target = "rowNumber", ignore = true)
	Member toEntity(MemberDto memberDto);
	
	@Mapping(target = "createdTimeAt", ignore = true)
	@Mapping(target = "isMember", ignore = true)
	@Mapping(target = "rowNumber", ignore = true)
	Member updateEntityFromDto(MemberDto memberDto, @MappingTarget Member member);
	
}
