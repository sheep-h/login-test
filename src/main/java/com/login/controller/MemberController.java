package com.login.controller;

import com.login.entity.Member;
import com.login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class MemberController {
	private final MemberRepository memberRepository;

	@GetMapping("/main")
	public String mainPage(@AuthenticationPrincipal User user, Model model) {
		Optional<Member> member = memberRepository.findByMemberId(user.getUsername());
		Member me = member.orElse(null);
		model.addAttribute("me", me);
		return "/member/main";
	}

	@GetMapping("/admin")
	public String adminPage(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		return "/admin/main";
	}
}
