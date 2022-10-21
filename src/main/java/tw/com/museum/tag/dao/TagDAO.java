package tw.com.museum.tag.dao;

import java.util.List;

import tw.com.museum.tag.domin.TagVo;

public interface TagDAO {
	public boolean insert(TagVo tagVo);
	public boolean update(TagVo tagVo);
	public boolean delete(Integer id);
	public TagVo selectById(Integer id);
	public List<TagVo> selectAll();


}
