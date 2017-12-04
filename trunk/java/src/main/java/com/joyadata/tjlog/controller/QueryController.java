package com.joyadata.tjlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyadata.tjlog.model.SessionLog;
import com.joyadata.tjlog.service.QueryService;
import com.joyadata.tjlog.util.Response;
import com.joyadata.tjlog.util.ResponseFactory;

/**
 * 数据查询
 * 
 * @ClassName: QueryController
 * @Description: QueryController
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月23日 上午10:51:27
 *
 */
@Controller
public class QueryController {
	
	@Autowired
	private QueryService service ;

	@ResponseBody
	@RequestMapping(value = "/data/query", method = RequestMethod.GET)
	public Response<List<SessionLog>> quert(String[] conditions, String tagIds, String startTime, String endTime,
			Integer page, Integer pager) {
		Integer total = 0;
		List<SessionLog> list = new ArrayList<SessionLog>();
		return ResponseFactory.makeResponse(list, page, pager, total);
	}
}
