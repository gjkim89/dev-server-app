package com.dev.server.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.server.dto.MemberDto;
import com.dev.server.mapper.MemberMapper;
import com.dev.server.model.Member;
import com.dev.server.repository.MemberRepository;
import com.dev.server.specification.MemberSpecs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	
	private final MemberMapper memberMapper;

	@Override
	public void addMember(MemberDto memberDto) throws Exception {
		
		Optional<Member> exist = memberRepository.findById(memberDto.getId());
		if(exist.isPresent()) {
			throw new Exception("이미 가입된 아이디입니다.");
		}else {
			Member member = memberMapper.toEntity(memberDto);
			memberRepository.save(member);
			log.info("save success : {}", member.getId());
		}

	}

	@Override
	public Page<Member> getMembers(Pageable pageable, String id, String name, int age, String sex, Date startTime,
			Date endTime) {
		
		Map<String, Object> keyword = new HashMap<>();
		if(id != null) {
			keyword.put("id", id);
		}
		if(name != null) {
			keyword.put("name", name);
		}
		if(id != null) {
			keyword.put("id", id);
		}
		if(age > 0) {
			keyword.put("age", age);
		}
		if(sex != null) {
			keyword.put("sex", sex);
		}
		if(startTime != null) {
			keyword.put("startTime", startTime);
		}
		if(endTime != null) {
			keyword.put("endTime", endTime);
		}
		
		
		return keyword.isEmpty()
				? memberRepository.findAll(pageable)
				: memberRepository.findAll(MemberSpecs.searchWith(keyword), pageable);
	}

	@Override
	public Member getMmeber(long rowNumber) {
		
		return memberRepository.findById(rowNumber).orElse(null);
	}

	@Override
	public void modifyMember(long rowNumber, MemberDto memberDto) throws Exception {
		
		Optional<Member> exist = memberRepository.findById(memberDto.getId());
		if(exist.get().getRowNumber() == rowNumber) {
			Member member = memberRepository.findById(rowNumber).orElse(null);
			
			member = memberMapper.updateEntityFromDto(memberDto, member);
			
			memberRepository.save(member);
			
			log.info("modify success : {}", member.getId());
		}else {
			throw new Exception("이미 가입된 아이디입니다.");
		}

	}

	@Override
	public void deleteMember(long rowNumber) {
		
		Member member = memberRepository.findById(rowNumber).orElse(null);
		member.setIsMember(false);
		
		memberRepository.save(member);
		
		log.info("delete success : {}", member.getId());

	}

}
