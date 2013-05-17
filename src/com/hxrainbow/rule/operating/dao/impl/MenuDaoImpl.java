package com.hxrainbow.rule.operating.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hxrainbow.rule.model.Menu;
import com.hxrainbow.rule.model.MenuNode;
import com.hxrainbow.rule.operating.dao.MenuDao;
@Repository("menuDao")
public class MenuDaoImpl  extends JdbcTemplate implements MenuDao {
	
	@Resource
	public void setDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	@Override
	public List<Menu> getMenuList(String role) {
		String sql="select m.id,m.name,m.url,m.image,m.parent_id from t_menu m,t_role r,t_role_menu rm where rm.role_id=r.id and rm.menu_id=m.id and r.name=? order by m.sequence";
		RowMapper<Menu> mapper=new RowMapper<Menu>() {
			@Override
			public Menu mapRow(ResultSet rs, int num) throws SQLException {
				Menu m=new Menu();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String url=rs.getString(3);
				String image=rs.getString(4);
				int pid=rs.getInt(5);
				m.setId(id);
				m.setName(name);
				if(url.indexOf('?')!=-1){
					if(!url.endsWith("?")){
						url=url+"&rel=m_"+id;
					}else{
						url=url+"rel=m_"+id;
					}
				}else{
					url=url+"?rel=m_"+id;
				}
				m.setUrl(url);
				
				m.setImage(image);
				m.setParentId(pid);
				return m;
			}
		};
		List<Menu> list=this.query(sql,new Object[]{role}, mapper);
		return list;
	}
	
	public List<MenuNode> getRoleMenuList(int id) {
		String sql="select m.id,m.name,rm.role_id>0 role,m.parent_id  from t_menu m left join t_role_menu rm on m.id=rm.menu_id  and rm.role_id=? order by m.parent_id,m.sequence";
		RowMapper<MenuNode> mapper=new RowMapper<MenuNode>() {
			@Override
			public MenuNode mapRow(ResultSet rs, int num)
					throws SQLException {
				MenuNode mn=new MenuNode();
				String value=rs.getString(1);
				String name=rs.getString(2);
				boolean check=rs.getBoolean(3);
				String pid=rs.getString(4);
				mn.setCheck(check);
				mn.setName(name);
				mn.setValue(value);
				mn.setParentId(pid);
				return mn;
			}
			
		};
		List<MenuNode> list=this.query(sql,new Object[]{id}, mapper);
		return list;
	}
	
	@Override
	public List<Menu> getMenuChildren(){
		String sql = "select max(sequence) from t_menu menu where menu.parent_id = 2";
		RowMapper<Menu> mapper=new RowMapper<Menu>() {
			@Override
			public Menu mapRow(ResultSet rs, int num) throws SQLException {
				Menu m=new Menu();
				int sequence=rs.getInt(1);				
				m.setSequence(sequence);				
				return m;
			}
		};
		List<Menu> list=this.query(sql, mapper);
		return list;
	}

	@Override
	public boolean save(Menu m) {
		boolean r = false;
		if (m.getId() == 0) {
			final String sql = "insert into t_menu(name,url,image,parent_id,sequence) value(?,?,?,?,?)";
			r = super.update(sql, m.getName(), m.getUrl(),m.getImage(),m.getParentId(),m.getSequence()) > 0;
		} else {
			final String sql = "update t_menu set name=?,url=?,image=?,parent_id=?,sequence=? where id=?";
			r = super.update(sql, m.getName(), m.getUrl(),m.getImage(),m.getParentId(),m.getSequence(), m.getId()) > 0;
		}
		return r;
	}

	@Override
	public void saveMenuRole(String sceneName) {
		final String sql ="INSERT INTO t_role_menu(role_id,menu_id) SELECT id,(SELECT id FROM t_menu menu WHERE menu.name=?) FROM t_role";
	    super.update(sql,sceneName);
	}
	@Override
	public void deleteMenu(String sceneName) {		
		final String sql="DELETE a,b FROM t_role_menu a JOIN t_menu b ON a.menu_id=b.id WHERE b.name =?";
		super.update(sql, sceneName);		
	}
    
}
