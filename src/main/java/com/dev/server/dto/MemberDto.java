package com.dev.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberDto {
	
	@ApiModelProperty(notes = "member 아이디", position = 1)
	private String id;
	
	@ApiModelProperty(notes = "member 이름", position = 2)
	private String name;
	
	@ApiModelProperty(notes = "member 나이", position = 3)
	private int age;
	
	@ApiModelProperty(notes = "member 성별", position = 4)
	private String sex;
	
}
