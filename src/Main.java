import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
        static int playerHealth = 100;
        static String playerLocation = "foyer";

        static int ghostDamage = 10;
        static int numGhosts = 0;
        static boolean hasKey = false;

        static boolean isAlive = true;

        static int playerDamage = 20;

        public static void main(String[] args) {
            System.out.println("In this game, you have to escape the haunted house. Type move, then a north, east, south or west to move to a different location.");
            System.out.println("Type search to search the room and get an item");
            System.out.println("Type attack , then a number to attack ghosts");
            while (isAlive) {
                printLocation(playerLocation);
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("search")) {
                    searchRoom();
                } else if (input.equals("move")) {
                    String direction = scanner.nextLine();
                    movePlayer(direction);
                } else if (input.equals("attack")) {
                    if (numGhosts > 0) {
                        attackGhosts(numGhosts);
                        numGhosts -= numGhosts;
                    }
                    else {
                        printError("There were no ghosts to be found");
                    }
                }
                else if (input.equals("quit")){
                    System.exit(0);
                }else {
                    printError("Invalid command");
                }
                if (playerHealth <= 0) {
                    isAlive = false;
                    print("You died");
                }
                if (playerLocation.equals("front door") && hasKey) {
                    isAlive = false;
                    print("You escaped!");
                }
            }
        }

        public static void print(String message) {
            System.out.print(message);
        }

        public static void printLine(String message) {
            System.out.println(message);
        }

        public static void printError(String message) {
            System.err.println(message);
        }

        public static void printHealth(int health) {
            printLine("Health: " + health);
        }

        public static void printLocation(String location) {
            printLine("You are in the " + location);
        }

    public static void movePlayer(String direction) {
        if (playerLocation.equals("foyer")) {
            if (direction.equals("north")) {
                playerLocation = "kitchen";
            } else if (direction.equals("east")) {
                playerLocation = "living room";
            } else if (direction.equals("south")) {
                playerLocation = "front door";
            } else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("kitchen")) {
            if (direction.equals("south")) {
                playerLocation = "foyer";
            } else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("living room")) {
            if (direction.equals("west")) {
                playerLocation = "foyer";
            } else if (direction.equals("north")) {
                playerLocation = "dining room";
            } else if (direction.equals("east")){
                playerLocation = "library";
            }else if (direction.equals("south")){
                playerLocation = "basement";
            }else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("dining room")) {
            if (direction.equals("south")) {
                playerLocation = "living room";
            } else {
                printError("Invalid direction");
            }
        } else if (playerLocation.equals("front door")) {
            printError("You need the key to unlock the door");
        }

        else if (playerLocation.equals("library")) {
            if (direction.equals("west")) {
                playerLocation = "living room";
            } else if (direction.equals("east")){
                playerLocation = "bedroom";
            }else if (direction.equals("north")){
                playerLocation = "bathroom";
            }
            else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("bedroom")) {
            if (direction.equals("west")) {
                playerLocation = "library";
            } else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("bathroom")) {
            if (direction.equals("north")) {
                playerLocation = "attic";
            } else if (direction.equals("south")) {
                playerLocation = "living room";
            } else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("attic")) {
            if (direction.equals("south")) {
                playerLocation = "bathroom";
            } else {
                printError("Invalid direction");
            }
        }

        else if (playerLocation.equals("basement")) {
            if (direction.equals("north")) {
                playerLocation = "living room";
            } else {
                printError("Invalid direction");
            }
        }
    }

    public static void searchRoom() {
        if (playerLocation.equals("foyer")) {
            printLine("You found a key!");
            hasKey = true;
        } else if (playerLocation.equals("kitchen")) {
            printLine("You found a health potion!");
            playerHealth += 20;
        } else if (playerLocation.equals("living room")) {
            printLine("You found ghosts!");
            numGhosts = 2;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+playerHealth);
        } else if (playerLocation.equals("dining room")) {
            printLine("You found ghosts!");
            numGhosts = 2;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+playerHealth);
        } else if (playerLocation.equals("library")) {
            printLine("You found ghosts!");
            numGhosts = 1;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+playerHealth);
        } else if (playerLocation.equals("bedroom")) {
            printLine("You found ghosts!");
            numGhosts = 1;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+playerHealth);
        } else if (playerLocation.equals("bathroom")) {
            printLine("You found a health potion!");
            playerHealth += 20;
        } else if (playerLocation.equals("attic")) {
            printLine("You found ghosts!");
            numGhosts = 3;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+ playerHealth);
        } else if (playerLocation.equals("basement")) {
            printLine("You found ghosts!");
            numGhosts = 3;
            playerHealth -= numGhosts * 10;
            System.out.println("Health: "+playerHealth);
        }
    }

    public static void attackGhosts(int numGhosts) {
        int totalDamage = numGhosts * playerDamage;
        numGhosts = 0;
        printLine("You defeated the ghosts!");
    }

    }