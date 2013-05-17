package com.hxrainbow.rule.operating.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.operating.dao.BaseJdbcTemplate;
import com.hxrainbow.rule.operating.dao.SceneEntityDao;

@Repository("sceneEntityDao")
public class SceneEntityDaoImpl extends BaseJdbcTemplate implements SceneEntityDao {

	@Override
	public List<Map<String, Object>> findEntityList(int sid) {
		String sql="SELECT e.id,e.name,e.identify,e.package_c,t.scene_id>0 checked  FROM t_entity e left join t_scene_entity t on (e.id=t.entity_id and t.scene_id=?)";
		RowMapper<Map<String,Object>> mapper=new RowMapper<Map<String,Object>>() {
			
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int num)
					throws SQLException {
				Map<String,Object> m=new HashMap<String, Object>();
				m.put("id", rs.getInt(1));
				m.put("name", rs.getString(2));
				m.put("identify", rs.getString(3));
				m.put("packageC", rs.getString(4));
				m.put("checked", rs.getBoolean(5));
				return m;
			}
		};
		List<Map<String,Object>> list=	super.query(sql,mapper , sid);
		return list;
	}

	@Override
	public int deleteEntityList(int id) {
		String sql="delete from t_scene_entity where scene_id=?";
		int i=super.update(sql, id);
		return i;
	}

	@Override
	public int saveSceneEntity(int entityId, int sceneId) {
		String sql="insert into t_scene_entity (entity_id,scene_id) values(?,?)";
		int i=super.update(sql, entityId,sceneId);
		return i;
	}
	
	

}
