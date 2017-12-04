package com.joyadata.tjlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyadata.tjlog.model.DataTagReg;
import com.joyadata.tjlog.model.Tag;
import com.joyadata.tjlog.model.TagReg;
import com.joyadata.tjlog.service.TagService;
import com.joyadata.tjlog.util.Generator;
import com.joyadata.tjlog.util.Response;
import com.joyadata.tjlog.util.ResponseFactory;

/**
 * 标签操作
 * 
 * @ClassName: TagController
 * @Description: TagController
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月21日 上午10:47:36
 *
 */
@Controller
public class TagController {

	@Autowired
	private TagService tagService;

	/**
	 * 
	 * @Description: 获取标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags", method = RequestMethod.GET)
	public Response<List<Tag>> getTags() {
		List<Tag> list = tagService.getAllTags();
		return ResponseFactory.makeResponse(list);
	}

	/**
	 * 
	 * @Description: 删除标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags/{tagId}", method = RequestMethod.DELETE)
	public Response<Tag> delTag(@PathVariable String tagId) {
		tagService.deleteTag(tagId);
		Tag tag = new Tag();
		tag.setId(tagId);
		return ResponseFactory.makeResponse(tag);
	}

	/**
	 * 
	 * @Description: 创建标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tag", method = RequestMethod.POST)
	public Response<Tag> tag(String name) {
		Tag tag = new Tag();
		tag.setName(name);
		tag.setId(Generator.uuid());
		tagService.addTag(tag);
		return ResponseFactory.makeResponse(tag);
	}

	/**
	 * 
	 * @Description: 获取标签匹配规则
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags/{id}/regs", method = RequestMethod.GET)
	public Response<List<TagReg>> tagReg(@PathVariable String id) {
		List<TagReg> list = tagService.getTagReg(id);
		return ResponseFactory.makeResponse(list);
	}

	/**
	 * 
	 * @Description: 添加标签匹配规则
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags/{id}/reg", method = RequestMethod.POST)
	public Response<TagReg> addReg(@PathVariable String id) {
		TagReg reg = new TagReg();
		reg.setId(Generator.uuid());
		reg.setTagId(id);
		tagService.addTagReg(reg);
		return ResponseFactory.makeResponse(reg);
	}

	/**
	 * 
	 * @Description: 删除标签匹配规则
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags/{tagId}/regs/{regId}", method = RequestMethod.DELETE)
	public Response<TagReg> delReg(@PathVariable String tagId, @PathVariable String regId) {

		tagService.delTagReg(regId);
		TagReg reg = new TagReg();
		reg.setTagId(tagId);
		reg.setId(regId);
		return ResponseFactory.makeResponse(reg);
	}

	/**
	 * 
	 * @Description: 更新标签匹配规则
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/tags/{tagId}/regs/{regId}", method = RequestMethod.POST)
	public Response<TagReg> regUpdate(@PathVariable String tagId, @PathVariable String regId, String field,
			String group, String regStr) {
		TagReg reg = new TagReg();
		reg.setId(regId);
		reg.setTagId(tagId);
		reg.setField(field);
		reg.setGroup(group);
		reg.setRegStr(regStr);
		tagService.updateTagReg(reg);
		return ResponseFactory.makeResponse(reg);
	}

	/**
	 * 
	 * @Description: 添加数据标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/log/reg", method = RequestMethod.POST)
	public Response<DataTagReg> addDataTagReg() {
		DataTagReg reg = new DataTagReg();
		reg.setId(Generator.uuid());
		tagService.addDataTagReg(reg);
		return ResponseFactory.makeResponse(reg);
	}

	/**
	 * 
	 * @Description: 获取数据标签列表
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/log/regs", method = RequestMethod.GET)
	public Response<List<DataTagReg>> getDataTagReg() {
		List<DataTagReg> list = tagService.getAllDataTagReg();
		return ResponseFactory.makeResponse(list);
	}

	/**
	 * 
	 * @Description: 更新数据标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/log/reg/{id}", method = RequestMethod.POST)
	public Response<DataTagReg> updateDataTagReg(@PathVariable String id, String tagId, String regStr, String status) {
		DataTagReg reg = new DataTagReg();
		reg.setId(id);
		reg.setTagId(tagId);
		reg.setRegStr(regStr);
		reg.setStatus(status);
		tagService.updateDataTagReg(reg);
		return ResponseFactory.makeResponse(reg);
	}

	/**
	 * 
	 * @Description: 删除数据标签
	 * @param name
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:03:32
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/data/log/reg/{id}", method = RequestMethod.DELETE)
	public Response<DataTagReg> delDataTagReg(@PathVariable String id) {
		DataTagReg reg = new DataTagReg();
		reg.setId(id);
		tagService.delDataTagReg(id);
		return ResponseFactory.makeResponse(reg);
	}

}
