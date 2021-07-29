package com.dev.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class Page {
	
	@ApiModelProperty(value = "페이지 번호(0)")
	private Integer page;
	
	@ApiModelProperty(value = "페이지 크기")
	private Integer size;
	
}
