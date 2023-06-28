package com.skytech.bcci.servive;

import com.skytech.bcci.model.Player;

import java.util.List;

public interface PlayerService {
    /**
     *
     * @param player
     * @return This method is used to inserting new data into player database with the help of PlayerDao
     */
    public int createPlayerEntry(Player player);

    /**
     *
     * @return This method is to display all the data in the database with the help of PlayerDao
     */
    public List<Player> diplayAll();

    /**
     *
     * @param id
     * @return This method is to return to display player by id with the help of PlayerDao
     */
    public Player getPlayerById(int id);

    /**
     *
     * @param player
     * @return This method is to update the player in database with the help of PlayerDao
     */
    public int updatePlayer(Player player);

    /**
     *
     * @param id
     * @return This method is to delete the player from database with the help of PlayerDao
     */
    public int deletePlayer(int id);

    /**
     *
     * @param email
     * @return This method is to get the details by email from database with the help of playerDao
     */
    public Player details(String email);

}
