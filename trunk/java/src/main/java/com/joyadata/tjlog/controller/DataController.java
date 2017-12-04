package com.joyadata.tjlog.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyadata.tjlog.util.Response;
import com.joyadata.tjlog.util.ResponseFactory;

@Controller
public class DataController {

	@ResponseBody
	@RequestMapping(value = "/data/{date}", method = RequestMethod.GET)
	public Response<List<Map<String, Object>>> getData(@PathVariable String date) throws ParseException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date serverDate = new Date();
		Date targetDate = sdf.parse(date);
		String today = sdf2.format(serverDate);

		String[] targetDayArray = date.split("-");
		String[] todayArray = today.split("-");
		Integer hour = 0;
		if (targetDayArray[0].equals(todayArray[0]) && targetDayArray[1].equals(todayArray[1])
				&& targetDayArray[2].equals(todayArray[2])) {// 同一天
			hour = Integer.parseInt(todayArray[3]);

		} else if (targetDate.getTime() < serverDate.getTime()) {// 目标时间小于当前时间
			hour = 24;

		}
		for (int i = 0; i < hour; i++) {
			String h = i + "";
			Map<String, Object> temp = new HashMap<String, Object>();
			if (h.length() < 2) {
				h = "0" + h;
			}
			temp.put("day", targetDayArray[2]);
			temp.put("hour", h);
			temp.put("value", randomInteger(5000000, 3500000));
			list.add(temp);
		}

		return ResponseFactory.makeResponse(list);
	}

	@ResponseBody
	@RequestMapping(value = "/data/{date}/tags/school", method = RequestMethod.GET)
	public Response<List<Map<String, Object>>> getDataSchool(@PathVariable String date) throws ParseException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date serverDate = new Date();
		Date targetDate = sdf.parse(date);
		String today = sdf2.format(serverDate);

		String[] targetDayArray = date.split("-");
		String[] todayArray = today.split("-");
		Integer hour = 0;
		if (targetDayArray[0].equals(todayArray[0]) && targetDayArray[1].equals(todayArray[1])
				&& targetDayArray[2].equals(todayArray[2])) {// 同一天
			hour = Integer.parseInt(todayArray[3]);

		} else if (targetDate.getTime() < serverDate.getTime()) {// 目标时间小于当前时间
			hour = 24;

		}
		for (int i = 0; i < hour; i++) {
			String h = i + "";
			Map<String, Object> temp = new HashMap<String, Object>();
			if (h.length() < 2) {
				h = "0" + h;
			}
			temp.put("day", targetDayArray[2]);
			temp.put("hour", h);
			temp.put("value", randomInteger(20000, 5000));
			list.add(temp);
		}

		return ResponseFactory.makeResponse(list);
	}

	@ResponseBody
	@RequestMapping(value = "/data/{date}/tags/school/people", method = RequestMethod.GET)
	public Response<List<Map<String, Object>>> getDataPeople(@PathVariable String date) throws ParseException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date serverDate = new Date();
		Date targetDate = sdf.parse(date);
		String today = sdf2.format(serverDate);

		String[] targetDayArray = date.split("-");
		String[] todayArray = today.split("-");
		Integer hour = 0;
		if (targetDayArray[0].equals(todayArray[0]) && targetDayArray[1].equals(todayArray[1])
				&& targetDayArray[2].equals(todayArray[2])) {// 同一天
			hour = Integer.parseInt(todayArray[3]);

		} else if (targetDate.getTime() < serverDate.getTime()) {// 目标时间小于当前时间
			hour = 24;

		}
		for (int i = 0; i < hour; i++) {
			String h = i + "";
			Map<String, Object> temp = new HashMap<String, Object>();
			if (h.length() < 2) {
				h = "0" + h;
			}
			temp.put("day", targetDayArray[2]);
			temp.put("hour", h);
			temp.put("value", randomInteger(200, 70));
			list.add(temp);
		}

		return ResponseFactory.makeResponse(list);
	}

	@ResponseBody
	@RequestMapping(value = "/data/{date}/app/top10", method = RequestMethod.GET)
	public Response<List<Map<String, Object>>> getTop10App(@PathVariable String date) throws ParseException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date serverDate = new Date();
		Date targetDate = sdf.parse(date);
		String today = sdf2.format(serverDate);

		String[] targetDayArray = date.split("-");
		String[] todayArray = today.split("-");
		if (targetDayArray[0].equals(todayArray[0]) && targetDayArray[1].equals(todayArray[1])
				&& targetDayArray[2].equals(todayArray[2]) || targetDate.getTime() < serverDate.getTime()) {// 同一天

			String apps[] = new String[] { "微信", "QQ", "新浪", "网易", "17173网游", "腾讯新闻", "今日头条", "百度新闻", "百度搜索", "必应搜索" };
			for (int i = 0; i < 10; i++) {
				String h = apps[i];
				Map<String, Object> temp = new HashMap<String, Object>();
				temp.put("name", h);
				temp.put("value", randomInteger(500000, 150000));
				list.add(temp);
			}
		}

		return ResponseFactory.makeResponse(list);
	}

	@ResponseBody
	@RequestMapping(value = "/data/{date}/browser/top5", method = RequestMethod.GET)
	public Response<List<Map<String, Object>>> getTop5Browser(@PathVariable String date) throws ParseException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date serverDate = new Date();
		Date targetDate = sdf.parse(date);
		String today = sdf2.format(serverDate);

		String[] targetDayArray = date.split("-");
		String[] todayArray = today.split("-");
		if (targetDayArray[0].equals(todayArray[0]) && targetDayArray[1].equals(todayArray[1])
				&& targetDayArray[2].equals(todayArray[2]) || targetDate.getTime() < serverDate.getTime()) {// 同一天

			String apps[] = new String[] { "chrome", "IE", "firefox", "safar", "opera" };
			for (int i = 0; i < 5; i++) {
				String h = apps[i];
				Map<String, Object> temp = new HashMap<String, Object>();
				temp.put("name", h);
				temp.put("value", randomInteger(500000, 150000));
				list.add(temp);
			}
		}

		return ResponseFactory.makeResponse(list);
	}

	public Integer randomInteger(int max, int min) {
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}
	
	
}
