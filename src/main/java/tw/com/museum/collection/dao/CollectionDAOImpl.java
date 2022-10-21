package tw.com.museum.collection.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.museum.collection.domin.CollectionVo;
import tw.com.museum.collectionImg.domin.ColImgVo;

@Repository
public class CollectionDAOImpl implements CollectionDAO {
	@PersistenceContext
	private Session session = null;

	public Session getSession() {
		return session;
	}

	@Override
	public boolean insert(CollectionVo collectionVo) {
		getSession().persist(collectionVo);
		return true;
	}

	@Override
	public boolean update(CollectionVo collectionVo) {
		final StringBuilder hql = new StringBuilder().append("UPDATE CollectionVo SET ");
		hql.append("collectionTitle = :collectionTitle, ")
			.append("collectionEar = :collectionEar, ")
			.append("collectionText = :collectionText, ")
			.append("collectionStatus = :collectionStatus, ")
			.append("collectionMaterial = :collectionMaterial ")
			.append("where collectionID = :collectionID");
		Query<?> query = getSession().createQuery(hql.toString());
		return query
				.setParameter("collectionTitle", collectionVo.getCollectionTitle())
				.setParameter("collectionEar", collectionVo.getCollectionEar())
				.setParameter("collectionText", collectionVo.getCollectionText())
				.setParameter("collectionStatus", collectionVo.getCollectionStatus())
				.setParameter("collectionMaterial", collectionVo.getCollectionMaterial())
				.setParameter("collectionID", collectionVo.getCollectionID())
				.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Integer collectionID) {
		ColImgVo colImgVo = new ColImgVo();
		colImgVo.setCollectionID(collectionID);
		getSession().remove(collectionID);
		return true;
	}

	@Override
	public CollectionVo findByPrimaryKey(Integer id) {
		try {
			// Query<CollectionVo> query = getSession().createQuery("FROM CollectionVo where
			// tagId = :tagId", CollectionVo.class);
			// query.setParameter("collectionID", id);
			// CollectionVo collectionID = query.uniqueResult();
			// return collectionID;
			return getSession()
					.createQuery("FROM CollectionVo where collectionID = :collectionID", CollectionVo.class)
					.setParameter("collectionID", id)
					.uniqueResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CollectionVo> findByName(String collectionTitle) {
		try {
			return getSession()
					.createQuery("FROM CollectionVo where collectionTitle like :collectionTitle order by collectionStatus desc, collectionID", CollectionVo.class)
					.setParameter("collectionTitle", "%"+collectionTitle+"%")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> findByMaterial(String collectionMaterial) {
		try {
			return getSession()
					.createQuery("FROM CollectionVo where collectionMaterial like :collectionMaterial order by collectionStatus desc, collectionID", CollectionVo.class)
					.setParameter("collectionMaterial", "%"+collectionMaterial+"%")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> findByEar(String collectionEar) {
		try {
			return getSession()
					.createQuery("FROM CollectionVo where collectionEar like :collectionEar order by collectionStatus desc, collectionID", CollectionVo.class)
					.setParameter("collectionEar", "%"+collectionEar+"%")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CollectionVo> getAll() {
		try {
			return getSession().createQuery("FROM CollectionVo order by collectionStatus desc", CollectionVo.class).list();
		} catch (Exception e) {
			return null;
		}
	}

}
