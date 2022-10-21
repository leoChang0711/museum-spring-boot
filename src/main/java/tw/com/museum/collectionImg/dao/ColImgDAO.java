package tw.com.museum.collectionImg.dao;

import java.util.List;

import tw.com.museum.collectionImg.domin.ColImgVo;

public interface ColImgDAO {
	public boolean insert(ColImgVo colImgVo);
	public boolean update(ColImgVo colImgVo);
	public boolean delect(Integer id);
	public ColImgVo selectById(Integer id);
	public List<ColImgVo> selectByName(ColImgVo colImgVo);
	List<ColImgVo> selectAll();


}
