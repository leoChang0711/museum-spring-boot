package tw.com.museum.tag.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.com.museum.tag.domin.TagVo;


@Repository
public class TagDAOImpl implements TagDAO {
	@PersistenceContext
	private Session session = null;

	public Session getSession() {
		return session;
	}

	@Override
	public boolean insert(TagVo tagVo) {
		getSession().persist(tagVo);
		return true;
	}

	@Override
	public boolean update(TagVo tagVo) {
		final StringBuilder hql = new StringBuilder().append("UPDATE TagVo SET ");
		 hql.append("tag = :tag ")
			.append("where tagID = :tagID");
		Query<?> query = getSession().createQuery(hql.toString());
		return query
				.setParameter("tag", tagVo.getTag())
				.setParameter("tagID", tagVo.getTagID())
				.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Integer id) {
		TagVo tag = getSession().load(TagVo.class, id);
		getSession().remove(tag);
		return true;
	}

	@Override
	public TagVo selectById(Integer id) {
		Query<TagVo> query =  getSession().createQuery("FROM TagVo where tagId = :tagId", TagVo.class);
		query.setParameter("tagId", id);
		TagVo tag = query.uniqueResult();
		return tag;
	}

	@Override
	public List<TagVo> selectAll() {
		Query<TagVo> query =  getSession().createQuery("FROM TagVo ", TagVo.class);
		List<TagVo> list = query.list();
		return list;
	}

}
