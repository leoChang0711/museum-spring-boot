package tw.com.museum.collectionImg.service;

import java.util.List;

import tw.com.museum.collectionImg.domin.ColImgVo;

public interface ColImgService {
	boolean add(ColImgVo colImgVo);
	ColImgVo remove(ColImgVo ColImg);
	public List<ColImgVo> getAll();
	public List<ColImgVo> getImgName(ColImgVo colImgVo);
}
