package com.skytech.bcci.dao.implementation;

import com.skytech.bcci.dao.PlayerDao;
import com.skytech.bcci.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.parameters.P;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

    private JdbcTemplate jdbcTemplate;


    @Override
    public int create(Player player) {
        String sql="insert into player(name,age,role,noOfMatches,email,password,authority) values(?,?,?,?,?,?,?)";
        try{
            int count=jdbcTemplate.update(sql,new Object[]{player.getName(),player.getAge(),player.getRole(),player.getNoOfMatches(),player.getEmail(),player.getPassword(),player.getAuthority()});
            return count;
        }
        catch(Exception e){
            System.out.println("There some issue while Inserting/Updating");
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Player> displayAll() {
        String sql="select * from player";
        List<Player> list=jdbcTemplate.query(sql, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                Player player=new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                player.setRole(rs.getString("role"));
                player.setNoOfMatches(rs.getInt("noOfMatches"));
                player.setEmail(rs.getString("email"));
                player.setPassword(rs.getString("password"));
                player.setAuthority(rs.getString("authority"));
                return player;
            }
        });
        return list;
    }

    @Override
    public Player getPlayerById(int id) {
        String sql="select * from player where id=?";
        Player player1=jdbcTemplate.queryForObject(sql,new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                Player player=new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                player.setRole(rs.getString("role"));
                player.setNoOfMatches(rs.getInt("noOfMatches"));
                player.setEmail(rs.getString("email"));
                player.setPassword(rs.getString("password"));
                player.setAuthority(rs.getString("authority"));
                return player;
            }
        },id);
        return player1;
    }

    @Override
    public int updatePlayer(Player player) {
        String sql="update player set name=?,age=?,role=?,noOfMatches=? where id=?";
        try {
            int count = jdbcTemplate.update(sql, new Object[]{player.getName(), player.getAge(), player.getRole(), player.getNoOfMatches(),player.getId()});
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deletePlayer(int id) {
        return jdbcTemplate.update("delete from player where id=?",id);
    }

    @Override
    public Player details(String email) {
        Player player1=null;
        try{
            String sql="Select * from player where email=?";
             player1=jdbcTemplate.queryForObject(sql,new RowMapper<Player>() {
                @Override
                public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Player player=new Player();
                    player.setId(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setAge(rs.getInt("age"));
                    player.setRole(rs.getString("role"));
                    player.setNoOfMatches(rs.getInt("noOfMatches"));
                    player.setEmail(rs.getString("email"));
                    player.setPassword(rs.getString("password"));
                    player.setAuthority(rs.getString("authority"));
                    return player;
                }
            },email);
        }catch (Exception e){
            return player1;
        }

        return player1;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
