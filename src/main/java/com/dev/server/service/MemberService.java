package com.dev.server.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev.server.dto.MemberDto;
import com.dev.server.model.Member;

public interface MemberService {
	
	public void addMember(MemberDto memberDto) throws Exception;
	
	public Page<Member> getMembers(Pageable pageable, String id, String name, int age, String sex,
			Date startTime, Date endTime);
	
	public Member getMmeber(long rowNumber);
	
	public void modifyMember(long rowNumber, MemberDto memberDto) throws Exception;
	
	public void deleteMember(long rowNumber);
	
}
