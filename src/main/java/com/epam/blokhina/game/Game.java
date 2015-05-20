package com.epam.blokhina.game;

import com.epam.blokhina.players.Comp;
import com.epam.blokhina.players.Player;
import com.epam.blokhina.players.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;


/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class Game implements GameInterface{
    UserInterface ui = new UserInterface();
    public static List<Player> playerList = new ArrayList();
    private static final Logger LOGGER = Logger.getLogger(Game.class);

    public void startGame() {
        ui.getHello();
        LOGGER.info("Game was started");
        ui.getParticipants();
        LOGGER.info("The list of participants has been initialized: " + playerList);
        ui.displayFirstCity();
        nextTurn();
    }


    public void nextTurn() {
        playerList.forEach(ui::getMove);
        nextTurn();
    }


    public void endGame() {
        ui.endGame();
        LOGGER.info("Game finished");
        System.exit(1);
    }


    private static class UserInterface {

        private void getHello() {
            System.out.println("Welcome to the game \"Cities\". The essence of the game - you must be a chain of words on the topic. " +
                    "\n Rules: the first player to name a word on a given topic, \n and the second player calls a word, " +
                    "the first letter \n of which coincides with the last letter of the word,\n called the first player. Next, a third player, etc. in turn.");
            System.out.println();
        }

        private List getParticipants() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of players");
            int choice = abs(sc.nextInt());
            System.out.println("Enter the number of live players");
            int liveChoice = abs(sc.nextInt());
            int cpuChoice = choice - liveChoice;
            for (int i = 0; i < choice; i++) {
                if (cpuChoice > 0) {
                    playerList.add(new Comp("cpu-player" + i));
                    cpuChoice--;
                }
                if (liveChoice > 0) {
                    playerList.add(new User("live-player" + (i)));
                    liveChoice--;
                }
            }
            return playerList;
        }

        private void getMove(Player player) {
            System.out.print(player.getName() + " move: ");
            player.sayCity();
        }

        private void endGame() {
            System.out.println("Game finished!");
            for (Player player : playerList) {
                System.out.println(player.getName() + " scored " + player.getScore() + " points");
            }
        }

        private void displayFirstCity() {
            System.out.println(Player.getPrevCity().getName());
        }
    }
}
