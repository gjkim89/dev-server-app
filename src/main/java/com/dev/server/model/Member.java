package com.dev.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "row_number")
	@ApiModelProperty(notes = "member rowNumber")
	private long rowNumber;
	
	@Column(name = "member_id", unique = true)
	@ApiModelProperty(notes = "member 아이디")
	private String id;
	
	@Column(name = "member_name")
	@ApiModelProperty(notes = "member 이름")
	private String name;
	
	@Column(name = "member_age")
	@ApiModelProperty(notes = "member 나이")
	private int age;
	
	@Column(name = "member_sex")
	@ApiModelProperty(notes = "member 성별")
	private String sex;
	
	@Column(name = "create_time_at")
	@ApiModelProperty(notes = "member 가입일")
	@CreationTimestamp
	private Date createdTimeAt;
	
	@Builder.Default
	@Column(name = "is_member")
	@ApiModelProperty(notes = "member 여부")
	private Boolean isMember = true;
	
}
