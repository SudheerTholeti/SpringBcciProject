package com.skytech.bcci.servive.Implementation;

import com.skytech.bcci.dao.implementation.PlayerDaoImpl;
import com.skytech.bcci.model.Player;
import com.skytech.bcci.servive.PlayerService;
import java.util.List;


public class PlayerServiceImpl implements PlayerService {

    private PlayerDaoImpl playerDao;

    @Override
    public int createPlayerEntry(Player player) {
       int count=playerDao.create(player);
       return count;
    }

    @Override
    public List<Player> diplayAll() {
        return playerDao.displayAll();
    }

    @Override
    public Player getPlayerById(int id) {
        return playerDao.getPlayerById(id);
    }

    @Override
    public int updatePlayer(Player player) {
        return playerDao.updatePlayer(player);
    }

    @Override
    public int deletePlayer(int id) {
        return playerDao.deletePlayer(id);
    }

    @Override
    public Player details(String email) {
        return playerDao.details(email);
    }

    public PlayerDaoImpl getPlayerDao() {
        return playerDao;
    }

    public void setPlayerDao(PlayerDaoImpl playerDao) {
        this.playerDao = playerDao;
    }

}
