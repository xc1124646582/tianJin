package com.joyadata.tjlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joyadata.tjlog.model.DataTagReg;
import com.joyadata.tjlog.model.Tag;
import com.joyadata.tjlog.model.TagReg;

/**
 * 标签操作
 * 
 * @ClassName: ITagDao
 * @Description: ITagDao
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月21日 上午10:54:00
 *
 */
public interface ITagDao {

	/**
	 * 
	 * @Description: 添加标签
	 * @param tag
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:54:12
	 * @version V1.0
	 */
	void addTag(Tag tag);

	/**
	 * 
	 * @Description: 根据标签id查询标签规则
	 * @param id
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:55:51
	 * @version V1.0
	 */
	List<TagReg> getTagReg(@Param("tagId") String id);

	/**
	 * 
	 * @Description: 添加标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:57:21
	 * @version V1.0
	 */
	void addTagReg(TagReg reg);

	/**
	 * 
	 * @Description: 更新标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 上午10:59:41
	 * @version V1.0
	 */
	void updateTagReg(TagReg reg);

	/**
	 * 
	 * @Description: 查询所有标签
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月21日 下午3:28:39
	 * @version V1.0
	 */
	List<Tag> getAllTags();

	/**
	 * 
	 * @Description: 删除标签
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月22日 上午9:27:07
	 * @version V1.0
	 */
	void deleteTag(@Param("tagId") String tagId);

	/**
	 * 
	 * @Description: 删除标签规则
	 * @param tagId
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月22日 上午9:34:06
	 * @version V1.0
	 */
	void deleteTagRegByTagId(@Param("tagId") String tagId);

	/**
	 * 
	 * @Description: 删除标签规则
	 * @param regId
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月22日 上午9:36:21
	 * @version V1.0
	 */
	void deleteTagReg(@Param("tagRegId") String regId);

	/**
	 * 
	 * @Description: 添加数据标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:28:29
	 * @version V1.0
	 */
	void addDataTagReg(DataTagReg reg);

	/**
	 * 
	 * @Description: 查询所有数据标签规则
	 * @return
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:33:10
	 * @version V1.0
	 */
	List<DataTagReg> getAllDataTagReg();

	/**
	 * 
	 * @Description: 更新数据标签规则
	 * @param reg
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:37:43
	 * @version V1.0
	 */
	void updateDataTagReg(DataTagReg reg);

	/**
	 * 
	 * @Description: 删除数据标签规则
	 * @param id
	 * @author 黄宏强 st8817@163.com
	 * @date 2017年11月23日 上午10:44:32
	 * @version V1.0
	 */
	void delDataTagReg(@Param("id")String id);

}
