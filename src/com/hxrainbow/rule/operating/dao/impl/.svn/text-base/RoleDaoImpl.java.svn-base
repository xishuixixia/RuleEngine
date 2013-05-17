package com.hxrainbow.rule.operating.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.Role;
import com.hxrainbow.rule.operating.dao.BaseJdbcTemplate;
import com.hxrainbow.rule.operating.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseJdbcTemplate implements RoleDao {

	@Override
	public List<Role> findList() {

		return this.findList(null);
	}

	@Override
	public List<Role> findList(String name) {
		StringBuilder sql = new StringBuilder(
				"select id,name,description from t_role");
		if (name != null) {
			sql.append(" where name like ?");
			name = "%" + name + "%";
		}
		sql.append(" limit 0,100");

		RowMapper<Role> mapper = new RowMapper<Role>() {
			@Override
			public Role mapRow(ResultSet rs, int num) throws SQLException {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String des = rs.getString(3);
				Role r = new Role();
				r.setId(id);
				r.setName(name);
				r.setDescription(des);
				return r;
			}
		};
		List<Role> list = null;
		if (name != null) {
			list = this.query(sql.toString(), new Object[] { name }, mapper);
		} else {
			list = this.query(sql.toString(), mapper);
		}
		return list;
	}

	public boolean save(final Role o) {
		boolean r = false;
		if (o.getId() == 0) {
			final String sql = "insert into t_role(name,description) value(?,?)";
			r = super.update(sql, o.getName(), o.getDescription()) > 0;
		} else {
			final String sql = "update t_role set name=?,description=? where id=?";
			r = super.update(sql, o.getName(), o.getDescription(), o.getId()) > 0;
		}
		return r;
	}

	public boolean deleteRoleMenu(int roleId){
		String sql = "delete from t_role_menu where role_id=?";
		return super.update(sql, roleId) >= 0;
	}
	@Override
	public boolean roleNameExist(String name) {
		String sql = "select count(1) c from t_role where name = ?";
		int i = this.queryForInt(sql, name);
		/*
		 * this.query(sql, new ResultSetExtractor<Boolean>(){
		 * 
		 * @Override public Boolean extractData(ResultSet rs) throws
		 * SQLException, DataAccessException { boolean r=false; if(rs.next()){
		 * r=rs.getLong(1)>0; } return r; }
		 * 
		 * });
		 */
		return i > 0;
	}

	@Override
	public Role getRoleById(final int id) {
		String sql = "select name,description from t_role where id=?";
		Role r = this.queryForObject(sql, new Object[] { id },
				new RowMapper<Role>() {
					@Override
					public Role mapRow(ResultSet rs, int num)
							throws SQLException {
						Role r = new Role();
						r.setId(id);
						r.setName(rs.getString(1));
						r.setDescription(rs.getString(2));
						return r;
					}

				});
		return r;
	}

	@Override
	public boolean delete(int id) {
		boolean r = false;
		String sql = "delete from t_role where id=?";
		r = super.update(sql, id) > 0;
		return r;
	}

	public boolean roleExist(int id) {
		String sql = "select count(1) from t_role where id=?";
		boolean r = this.queryForObject(sql, new Object[] { id },
				new RowMapper<Boolean>() {
					@Override
					public Boolean mapRow(ResultSet rs, int num)
							throws SQLException {
						return rs.getInt(1) > 0;
					}
				});
		return r;
	}

	@Override
	public int saveRoleMenu(int menuId, int roleId) {
		String sql="insert into t_role_menu(role_id,menu_id) value(?,?)";
		int i=super.update(sql,roleId,menuId);
		return i;
	}

}
