package tw.com.museum.collection.dao;
import java.util.List;

import tw.com.museum.collection.domin.CollectionVo;



public interface CollectionDAO {
	public boolean insert(CollectionVo collectionVo);
	public boolean update(CollectionVo collectionVo);
	public boolean delete(Integer collectionID);
	
	public abstract CollectionVo findByPrimaryKey(Integer id);
	List<CollectionVo> findByName(String collectionTitle);
	List<CollectionVo> findByMaterial(String collectionMaterial);
	List<CollectionVo>  findByEar(String collectionEar);
//	CollectionVo findByNameMaterial(String collectionVO);
//	CollectionVo findByNameEar(String collectionVO);
//	CollectionVo findByEarMaterial(String collectionVO);
//	CollectionVo findByNEM(String collectionVO);

	public List<CollectionVo> getAll();
}
