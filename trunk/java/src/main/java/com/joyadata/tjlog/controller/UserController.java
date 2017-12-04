package com.joyadata.tjlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyadata.tjlog.model.User;
import com.joyadata.tjlog.service.UserService;
import com.joyadata.tjlog.util.Generator;
import com.joyadata.tjlog.util.Response;
import com.joyadata.tjlog.util.ResponseFactory;

/**
 * 用户
 * 
 * @ClassName: UserController
 * @Description: UserController
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月24日 上午9:45:54
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @Description: 登陆
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public Response<User> login(String username, String password) {
		User user = userService.getUser(username, password);
		if (null != user) {
			user.setToken(Generator.uuid());
			return ResponseFactory.makeResponse(user);
		}
		return ResponseFactory.makeResponse(Response.Code.Error, "账号或密码错误", user);

	}

}
