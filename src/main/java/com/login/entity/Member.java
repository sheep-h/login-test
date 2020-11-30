package com.login.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {

	@Id
	@GeneratedValue
	private Long id;

	private String memberId;

	private String password;

	private String memberName;

	public Member(String memberId, String password, String memberName) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
