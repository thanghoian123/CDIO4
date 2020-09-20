package com.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.model.dto.UserDTO;
import com.petcare.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/user/un={username}-pass={password}")
	public ResponseEntity<?> checkLogin(@PathVariable("username") String un, @PathVariable("password") String pass) {
		UserDTO user = new UserDTO();
		user.setUserName(un);
		user.setPassword(pass);
		user = userService.checkLogin(user);
		return (user == null) ? ResponseEntity.ok("Thông tin đăng nhập không chính xác") : ResponseEntity.ok(user);
	}

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody UserDTO model) {
		if (userService.isExistUserName(model.getUserName())) {
			return ResponseEntity.ok("Đã tồn tại tên tài khoản này");
		}
		model.setStatus("true");
		UserDTO user = userService.save(model);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		UserDTO user = userService.save(model);
		return ResponseEntity.ok(user);
	}
}
