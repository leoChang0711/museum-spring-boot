package tw.com.museum.collection.service;

import java.util.List;

import tw.com.museum.collection.domin.CollectionVo;

public interface CollectionService {
	CollectionVo add(CollectionVo collection);
	CollectionVo edit(CollectionVo collection);
	CollectionVo findId(Integer collectionID);
	CollectionVo deleteId(Integer collectionID);
    List<CollectionVo> findName(String collectionTitle);
    List<CollectionVo> findMaterial(String collectionMaterial);
    List<CollectionVo> findEar(String collectionEar);
    
	public List<CollectionVo> getAll();

}
