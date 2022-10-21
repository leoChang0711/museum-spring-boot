package tw.com.museum.tag.service;

import java.util.List;

import tw.com.museum.tag.domin.TagVo;

public interface TagService {
	TagVo addTag(TagVo tag);
	TagVo editTag(TagVo tag);
	TagVo findById(TagVo tag);
	TagVo deleteId(Integer id);

	public List<TagVo> getAll();
}
