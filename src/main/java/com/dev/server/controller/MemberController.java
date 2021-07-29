package com.dev.server.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.server.dto.MemberDto;
import com.dev.server.model.Member;
import com.dev.server.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = "member-controller")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "server")
public class MemberController {
	
	private final MemberService memberService;
	
	/* member 등록 */
	@ApiOperation(value = "member 등록", notes = "member 등록")
	@PostMapping(value = "members")
	public ResponseEntity<String> addMember(@ApiParam(value = "등록할 member 정보", required = true) @RequestBody MemberDto memberDto) throws Exception{
		
		memberService.addMember(memberDto);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	/* member 전체 조회 */
	@ApiOperation(value = "member 전체 조회", notes = "member 전체 조회")
	@GetMapping(value = "members")
	public ResponseEntity<Page<Member>> getMembers(
			@PageableDefault(sort = "rowNumber", direction = Sort.Direction.DESC) Pageable pageable,
			@ApiParam(value = "member id", required = false) @RequestParam(required = false) String id,
			@ApiParam(value = "member name", required = false) @RequestParam(required = false) String name,
			@ApiParam(value = "member age", required = false) @RequestParam(defaultValue = "0", required = false) int age,
			@ApiParam(value = "member sex", required = false) @RequestParam(required = false) String sex,
			@ApiParam(value = "startTime", required = false) @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date startTime,
			@ApiParam(value = "endTime", required = false) @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endTime) {
		
		
		return new ResponseEntity<>(memberService.getMembers(pageable, id, name, age, sex, startTime, endTime), HttpStatus.OK);
	}
	
	/* member 조회 */
	@ApiOperation(value = "member 상세 조회", notes = "member 상세 조회")
	@GetMapping(value = "members/{rowNumber}")
	public ResponseEntity<Member> getMember(@ApiParam(value = "조회할 member 고유 번호", required = true) @PathVariable long rowNumber) {
		
		return new ResponseEntity<>(memberService.getMmeber(rowNumber), HttpStatus.OK);
	}
	
	/* member 수정 */
	@ApiOperation(value = "member 수정", notes = "member 수정")
	@PutMapping(value = "members/{rowNumber}")
	public ResponseEntity<String> modifyMember(@ApiParam(value = "수정할 member 고유 번호", required = true) @PathVariable long rowNumber,
			@RequestBody MemberDto memberDto) throws Exception {
		
		memberService.modifyMember(rowNumber, memberDto);
				
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	/* member 삭제 */
	@ApiOperation(value = "member 삭제", notes = "member 삭제")
	@DeleteMapping(value = "members/{rowNumber}")
	public ResponseEntity<String> deleteMember(@ApiParam(value = "삭제할 member 고유 번호", required = true) @PathVariable long rowNumber) {
		
		memberService.deleteMember(rowNumber);
				
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
