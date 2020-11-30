package com.login.controller;

import com.login.entity.Member;
import com.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final PasswordEncoder passwordEncoder;
	private final MemberRepository memberRepository;

	@GetMapping({"/", "/login"})
	public String login(Model model) {
		return "/login/login";
	}

	@GetMapping("/login/newMember")
	public String memberJoinForm(Member memberForm) {
		return "/login/form";
	}

	@PostMapping("/login/newMember")
	public String memberJoin(Member memberForm) {
		memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));
		memberRepository.save(memberForm);
		return "/login/form";
	}

}
