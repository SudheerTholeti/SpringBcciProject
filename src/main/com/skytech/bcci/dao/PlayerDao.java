package com.skytech.bcci.dao;



import com.skytech.bcci.model.Player;

import java.util.List;

public interface PlayerDao {
    /**
     *
     * @param player
     * @return This method is inserting new data into the database
     */
    public int create(Player player);

    /**
     *
     * @return This method is used to display all the players list in database
     */
    public List<Player> displayAll();

    /**
     *
     * @param id
     * @return This method is to return to display player by id
     */
    public Player getPlayerById(int id);

    /**
     *
     * @param player
     * @return This method is to update the player in database
     */
    public int updatePlayer(Player player);

    /**
     *
     * @param id
     * @return This method is to delete the player in database
     */
    public int deletePlayer(int id);

    /**
     *
     * @param email
     * @return This method is to get the details by using email in database
     */
    public Player details(String email);

}
