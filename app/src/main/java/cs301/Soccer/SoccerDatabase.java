package cs301.Soccer;

import android.util.Log;
import cs301.Soccer.soccerPlayer.SoccerPlayer;
import java.io.File;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    //Declaration and initialization of the Hashtable
    private Hashtable database = new Hashtable();
    String key;

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName) {
        key = firstName + " || " + lastName;

        if(database.get(key) != null)
        {
            return false;
        }
        else
        {
            SoccerPlayer putPlayer = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
            database.put(key, putPlayer);
        }
        return true;
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        key = firstName + " || " + lastName;

        if(database.get(key) != null)
        {
            database.remove(key);
            return true;
        }
        else
        {
            return false;
        }



    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    public SoccerPlayer getPlayer(String firstName, String lastName) {
        key = firstName + " || " + lastName;

        if(database.get(key) != null)
        {
            return (SoccerPlayer) database.get(key);
        }
        return null;
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        key = firstName + " || " + lastName;
        if(database.containsKey(key))
        {
            SoccerPlayer currPlayer = (SoccerPlayer) database.get(key);
            currPlayer.bumpGoals();
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        key = firstName + " || " + lastName;
        if(database.containsKey(key))
        {
            SoccerPlayer currPlayer = (SoccerPlayer) database.get(key);
            currPlayer.bumpYellowCards();
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        key = firstName + " || " + lastName;
        if(database.containsKey(key))
        {
            SoccerPlayer currPlayer = (SoccerPlayer) database.get(key);
            currPlayer.bumpRedCards();
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName) {
        int numCounted = 0;
        String[] keyArray = (String[])database.keySet().toArray();
        if(teamName == null)
        {
            for(int i = 0; i<database.size(); i++)
            {
              numCounted++;
            }
        }
        else
        {
            for (int i = 0; i<database.size(); i++)
            {
                   numCounted++;
            }
        }
        return numCounted;
    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerIndex(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerIndex(int idx, String teamName) {
        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {
        return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        return false;
    }

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see cs301.Soccer.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

    /**
     * Helper method to empty the database and the list of teams in the spinner;
     * this is faster than restarting the app
     */
    public boolean clear() {
        if(database != null) {
            database.clear();
            return true;
        }
        return false;
    }
}
