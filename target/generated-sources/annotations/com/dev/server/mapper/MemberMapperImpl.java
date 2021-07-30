package com.dev.server.mapper;

import com.dev.server.dto.MemberDto;
import com.dev.server.model.Member;
import com.dev.server.model.Member.MemberBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-30T11:18:31+0900",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.21.0.v20200304-1404, environment: Java 1.8.0_45 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberDto memberDto) {

        MemberBuilder member = Member.builder();

        if ( memberDto != null ) {
            member.age( memberDto.getAge() );
            if ( memberDto.getId() != null ) {
                member.id( memberDto.getId() );
            }
            if ( memberDto.getName() != null ) {
                member.name( memberDto.getName() );
            }
            if ( memberDto.getSex() != null ) {
                member.sex( memberDto.getSex() );
            }
        }

        return member.build();
    }

    @Override
    public Member updateEntityFromDto(MemberDto memberDto, Member member) {

        if ( memberDto != null ) {
            member.setAge( memberDto.getAge() );
            if ( memberDto.getId() != null ) {
                member.setId( memberDto.getId() );
            }
            else {
                member.setId( null );
            }
            if ( memberDto.getName() != null ) {
                member.setName( memberDto.getName() );
            }
            else {
                member.setName( null );
            }
            if ( memberDto.getSex() != null ) {
                member.setSex( memberDto.getSex() );
            }
            else {
                member.setSex( null );
            }
        }

        return member;
    }
}
