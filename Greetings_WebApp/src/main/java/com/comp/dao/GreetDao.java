package com.comp.dao;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.comp.beans.GreetingsMain;
  
public class GreetDao {
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}

public int save(GreetingsMain p){
    String sql="insert into sharkhangreetings(name, date_ddmm, hellosaid) values('"+p.getName()+"',"+p.getDate_ddmm()+",'"+p.getHellosaid()+"')";
    return template.update(sql);  
}  
public int update(GreetingsMain p){
    String sql="update sharkhangreetings set name='"+p.getName()+"', date_ddmm="+p.getDate_ddmm()+",hellosaid='"+p.getHellosaid()+"' where id="+p.getId()+"";
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from sharkhangreetings where id="+id+"";
    return template.update(sql);  
}  
public GreetingsMain getGreetById(int id){
    String sql="select * from sharkhangreetings where id=?";
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<GreetingsMain>(GreetingsMain.class));
}  
public List<GreetingsMain> getGreetings(){
    return template.query("select * from sharkhangreetings",new RowMapper<GreetingsMain>(){
        public GreetingsMain mapRow(ResultSet rs, int row) throws SQLException {
            GreetingsMain e=new GreetingsMain();
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setDate_ddmm(rs.getFloat(3));
            e.setHellosaid(rs.getString(4));
            return e;  
        }  
    });  
}  
}  