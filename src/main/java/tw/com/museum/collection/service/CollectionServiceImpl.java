package tw.com.museum.collection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.museum.collection.dao.CollectionDAO;
import tw.com.museum.collection.domin.CollectionVo;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionVo result;
	@Autowired
	private CollectionDAO collectionDAO;

	@Override
	public CollectionVo add(CollectionVo collectionVo) {
		if ("".equals(collectionVo.getCollectionTitle())) {
			result.setMessage("名稱未輸入");
			result.setSuccessful(false);
			return result;
		}

		if ("".equals(collectionVo.getCollectionText())) {
			result.setMessage("說明未輸入");
			result.setSuccessful(false);
			return result;
		}
		if ("".equals(collectionVo.getCollectionEar())) {
			result.setMessage("朝代未輸入");
			result.setSuccessful(false);
			return result;
		}
		if ("".equals(collectionVo.getCollectionMaterial())) {
			result.setMessage("類別未輸入");
			result.setSuccessful(false);
			return result;
		}

		if (collectionVo.getCollectionStatus() == null) {
			result.setMessage("狀態未輸入");
			result.setSuccessful(false);
			return result;
		}
		if (collectionDAO.insert(collectionVo) == false) {
			result.setMessage("新增發生錯誤!");
			result.setSuccessful(false);
			return result;

		}
		result.setSuccessful(true);
		return result;
	}

	@Override
	public CollectionVo edit(CollectionVo collection) {
		if ("".equals(collection.getCollectionTitle())) {
			result.setMessage("資料更改出現錯誤，名稱不可為空");
			result.setSuccessful(false);
			return result;
		}
		if ("".equals(collection.getCollectionText())) {
			result.setMessage("資料更改出現錯誤，說明不可為空");
			result.setSuccessful(false);
			return result;
		}

		if (collectionDAO.update(collection) == false) {
			result.setMessage("新增發生錯誤!");
			result.setSuccessful(false);
			return result;

		}
		result.setMessage("資料更改成功");
		result.setSuccessful(true);
		return result;
	}

	@Override
	public CollectionVo findId(Integer collectionID) {
		try {
			result = collectionDAO.findByPrimaryKey(collectionID);
			if (result == null) {
				return result;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> findName(String collectionTitle) {
		try {
			List<CollectionVo> list = collectionDAO.findByName(collectionTitle);
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> findMaterial(String collectionMaterial) {
		try {
			List<CollectionVo> list = collectionDAO.findByMaterial(collectionMaterial);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> findEar(String collectionEar) {
		try {
			List<CollectionVo> list = collectionDAO.findByEar(collectionEar);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List<CollectionVo> getAll() {
		return collectionDAO.getAll();

	}
	
	@Override
	public CollectionVo deleteId(Integer collectionID) {
		if (collectionDAO.delete(collectionID) == false) {
			result.setMessage("刪除發生錯誤!");
			result.setSuccessful(false);
			return result;

		}
		result.setSuccessful(true);
		return result;
	}

}
