package tw.com.museum.collectionImg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.museum.collectionImg.dao.ColImgDAO;
import tw.com.museum.collectionImg.domin.ColImgVo;

@Service
public class ColImgServiceImpl implements ColImgService {

	@Autowired
	private ColImgDAO colImgDAO;

	@Override
	public boolean add(ColImgVo colImgVo) {
		return colImgDAO.insert(colImgVo);
	}

	@Override
	public ColImgVo remove(ColImgVo ColImg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColImgVo> getAll() {
		return colImgDAO.selectAll();

	}

	@Override

	public List<ColImgVo> getImgName(ColImgVo colImgVo) {
		List<ColImgVo> list = colImgDAO.selectByName(colImgVo);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getImageName();
		}
		return list;
	}

}
