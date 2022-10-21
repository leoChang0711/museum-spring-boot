package tw.com.museum.collectionImg.dao;

import java.util.List;

import org.hibernate.Session;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import tw.com.museum.collectionImg.domin.ColImgVo;

@Repository
public class ColImgDAOImpl implements ColImgDAO {
	@PersistenceContext
	private Session session = null;

	public Session getSession() {
		return session;
	}


	@Override
	public boolean insert(ColImgVo colImgVo) {
		getSession().save(colImgVo);
		return true;
	}

	@Override
	public boolean update(ColImgVo colImgVo) {
		final StringBuilder hql = new StringBuilder().append("UPDATE colImg SET ");
		hql.append("imageName = :imageName, ");
	Query<?> query = getSession().createQuery(hql.toString());
	return query
		.setParameter("imageName", colImgVo.getImageName()) 
		.executeUpdate() >0 ;
	}

	@Override
	public boolean delect(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ColImgVo selectById(Integer id) {
		Query<ColImgVo> query = getSession().createQuery("FROM ColImgVo WHERE imageID = :imageID", ColImgVo.class);
		query.setParameter("imageID", id);
		ColImgVo ColImgId = query.uniqueResult();
		return ColImgId;
	}

	@Override
	public List<ColImgVo> selectAll() {
		Query<ColImgVo> query = getSession().createQuery("FROM ColImgVo", ColImgVo.class);
		List<ColImgVo> list = query.list();
		return list;
	}


	@Override
	public List<ColImgVo> selectByName(ColImgVo colImgVo) {
			return getSession()
					.createQuery("FROM ColImgVo WHERE collectionID = :collectionID", ColImgVo.class)
					.setParameter("collectionID", colImgVo.getCollectionID())
					.list();	
	}

}
