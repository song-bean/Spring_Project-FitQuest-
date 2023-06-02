package health.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthDateDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace = "health.model.HealthDate";
	
	public List<HealthDateBean> getMyHealthDateList(String id) {
		List<HealthDateBean> hdlist = new ArrayList<HealthDateBean>();
		hdlist = sqlSessionTemplate.selectList(namespace + ".GetMyHealthDateList", id);
		return hdlist;
	}
}