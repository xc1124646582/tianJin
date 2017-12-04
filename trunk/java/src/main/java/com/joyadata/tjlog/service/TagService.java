package com.joyadata.tjlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyadata.tjlog.dao.ITagDao;
import com.joyadata.tjlog.model.DataTagReg;
import com.joyadata.tjlog.model.Tag;
import com.joyadata.tjlog.model.TagReg;

/**
 * 标签操作
 * 
 * @ClassName: TagService
 * @Description: TagService
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月21日 上午10:48:00
 *
 */
@Service
public class TagService {

	@Autowired
	private ITagDao dao;

	/**
	 * 
	 * @Description: 添加标签
	 * @param tag
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:51:04
	 * @version V1.0
	 */
	public void addTag(Tag tag) {
		dao.addTag(tag);
	}

	/**
	 * 
	 * @Description: 根据标签id查询标签规则
	 * @param id
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:55:08
	 * @version V1.0
	 */
	public List<TagReg> getTagReg(String id) {
		return dao.getTagReg(id);
	}

	/**
	 * 
	 * @Description: 添加标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:56:46
	 * @version V1.0
	 */
	public void addTagReg(TagReg reg) {
		dao.addTagReg(reg);
	}

	/**
	 * 
	 * @Description: 更新标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:59:07
	 * @version V1.0
	 */
	public void updateTagReg(TagReg reg) {
		dao.updateTagReg(reg);
	}

	/**
	 * 
	 * @Description: 查询所有标签
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 下午3:22:36
	 * @version V1.0
	 */
	public List<Tag> getAllTags() {
		return dao.getAllTags();
	}

	/**
	 * 
	 * @Description: 删除标签和规则
	 * @param tagId
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月22日 上午9:35:16
	 * @version V1.0
	 */
	public void deleteTag(String tagId) {
		// TODO 检查数据引用
		dao.deleteTagRegByTagId(tagId);
		dao.deleteTag(tagId);

	}

	/**
	 * 
	 * @Description: 删除标签规则
	 * @param regId
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月22日 上午9:35:37
	 * @version V1.0
	 */
	public void delTagReg(String regId) {
		dao.deleteTagReg(regId);
	}

	/**
	 * 
	 * @Description: 添加数据标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:27:59
	 * @version V1.0
	 */
	public void addDataTagReg(DataTagReg reg) {
		dao.addDataTagReg(reg);
	}

	/**
	 * 
	 * @Description: 查询所有数据标签规则
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:32:47
	 * @version V1.0
	 */
	public List<DataTagReg> getAllDataTagReg() {
		return dao.getAllDataTagReg();
	}

	/**
	 * 
	 * @Description: 更新数据标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:37:07
	 * @version V1.0
	 */
	public void updateDataTagReg(DataTagReg reg) {
		dao.updateDataTagReg(reg);
	}

	/**
	 * 
	 * @Description: 删除数据标签规则
	 * @param id
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:44:03
	 * @version V1.0
	 */
	public void delDataTagReg(String id) {
		dao.delDataTagReg(id);
	}

}
