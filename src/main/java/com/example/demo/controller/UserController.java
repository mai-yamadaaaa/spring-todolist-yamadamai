package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CreateUser;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/users/add")
	public String createUser() {
		return "createUser";
	}

	@PostMapping("/users/add")
	public String add(
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "password_comfirm", defaultValue = "") String password_comfirm,
			Model model) {

		if (email == null || email.length() == 0 || name == null || name.length() == 0 ||
				password == null || password.length() == 0 || password_comfirm == null || password.length() == 0) {
			model.addAttribute("message", "空欄があります。入力してください");
		} else if (password.equals(password_comfirm)) {
			model.addAttribute("message", "入力されたパスワードが一致しません");
		}

		//users（アカウント情報）DBに格納
		CreateUser createUser = new CreateUser(email, name, password);
		accountRepository.save(createUser);

		return "redirect:/login";
	}

	@GetMapping({ "/", "/login" })
	public String index(@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		//セッション情報を全てクリアする
		session.invalidate();
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}
		return "login";
	}

	//ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {

		//名前が空の場合にエラーとする
		if (email.isEmpty() || password.isEmpty()) {
			model.addAttribute("message", "名前を入れてください");
			return "login";
		}

		CreateUser createUser = accountRepository.findByEmailAndPassword(email, password);

		if (createUser == null) {
			model.addAttribute("message", "アカウントが存在しません");
			return "login";
		}

		account.setName(createUser.getName());

		return "redirect:/tasks";
	}

}
