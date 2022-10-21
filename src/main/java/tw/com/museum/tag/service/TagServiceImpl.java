package tw.com.museum.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.museum.tag.dao.TagDAO;
import tw.com.museum.tag.domin.TagVo;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagVo result;
	@Autowired
	private TagDAO tagDAO;
	
	
	@Override
	public TagVo addTag(TagVo tag) {
			if ("".equals(tag.getTag())) {
				result.setMessage("類別名稱未輸入");
				result.setSuccessful(false);
				return result;
			}
			
			if (tagDAO.insert(tag) == false) {
				result.setMessage("新增發生錯誤!");
				result.setSuccessful(false);
				return result;
			}
			result.setMessage("新增成功");
			result.setSuccessful(true);
			return result;
	}

	@Override
	public TagVo editTag(TagVo tag) {
		try {
			result.setTagID(result.getTagID());
			final boolean resultCount = tagDAO.update(tag);
			result.setSuccessful(resultCount == true);
			result.setMessage(resultCount == true ? "修改成功" : "修改失敗");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TagVo findById(TagVo tag) {
		try {
			result = tagDAO.selectById(result.getTagID());
			result.setSuccessful(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TagVo> getAll() {
		try {
			return tagDAO.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TagVo deleteId(Integer id) {
		if (tagDAO.delete(id) == false) {
			result.setMessage("刪除發生錯誤!");
			result.setSuccessful(false);
			return result;
		}
		result.setSuccessful(true);
		return result;
	}
}
