import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**                         !!!!!!!!!!Assumptions!!!!!!!!!!
 * Code is built up assuming that all the fuel queues are completely full at the beginning of the program
 *
 * Student Name - Thanuja Hennayake
 * Student Id - w1902244
 *
 */

public class main {
    /**
     * Initializing Variables
     */
    public static int fuelStock = 6600;

    public static Scanner input = new Scanner(System.in);

    static String[] queueOne = {"thanuja", "lakshitha", "hennayake", "nadun", "tharuka", "lucky"};


    static String[] queueTwo = {"saman", "kamal", "lakmal", "chamath", "charaka", "charuka"};


    static String[] queueThree = {"pramuditha", "nadun", "sehan", "damsri", "thisan", "roshan"};

    static String [] copyQ1 = new String[6];
    static String [] copyQ2 = new String[6];
    static String [] copyQ3 = new String[6];

    static String[][] mainQueue = {copyQ1,copyQ2,copyQ3};

    static int count1, count2, count3 = 0;


    //------------------------------------------------------------------------------------------------------------------

    /**
     * Viewing all the fuel queues
     * No Input parameters
     *
     */
    public static String viewQueue() {
        String Q1 = "Queue one = " + Arrays.toString(queueOne);
        String Q2 = "Queue two = " + Arrays.toString(queueTwo);
        String Q3 = "Queue three = " + Arrays.toString(queueThree);
        return Q1 + "\n" + Q2 + "\n" + Q3;
    }
    //------------------------------------------------------------------------------------------------------------------


    /**
     * Restocking Fuel
     * Input parameter - new fuel amount
     */
    public static String addFuel(int newAmount) {
        boolean addFuelLoop = true;
        String output = "";
        int checkStock = fuelStock + newAmount;
        if (checkStock > 6600) {
            output = ("                  !!!!!!!!!!!!!!!!!!!!!!ALERT!!!!!!!!!!!!!!!!!!!!\n" +
                    "                    Cannot restock fuel Maximum fuel limit exceeded \n" +
                    "                      Maximum amount you can refuel is " + (6600 - fuelStock));
        } else {
            fuelStock = fuelStock + newAmount;
            output = ("Fuel restock successful. New stock = " + fuelStock);
        }
        return output;
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Viewing all the empty fuel queues
     * no input parameters
     */
    public static void viewEmptyQueue() {
        //int count1 = 0;
        for (int i = 0; i < queueOne.length; i++) {
            if (queueOne[i] == "") {
                count1++;
            }
        }
        if (count1 > 0) {
            System.out.println("Queue one has " + count1 + " empty slots");
        }


        //int count2 = 0;
        for (int i = 0; i < queueTwo.length; i++) {
            if (queueTwo[i] == "") {
                count2++;
            }
        }
        if (count2 > 0) {
            System.out.println("Queue two has " + count2 + " empty slots");
        }


        //int count3 = 0;
        for (int i = 0; i < queueThree.length; i++) {
            if (queueThree[i] == "") {
                count3++;
            }
        }
        if (count3 > 0) {
            System.out.println("Queue three has " + count3 + " empty slots");
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Removing a customer to a given fuel queue
     * input - removing index / number of the queue
     */

    public static void removeCustomer(int index, int queueNo) {
        switch (queueNo) {
            case 1:
                String[] duplicateOne = new String[queueOne.length];
                for (int i = 0, k = 0; i < queueOne.length; i++) {
                    if (i != index) {
                        duplicateOne[k] = String.valueOf((queueOne[i]));
                        k++;
                    }
                }
                duplicateOne[5] = "";
                queueOne = duplicateOne;
                System.out.println("\nRemoved the element successfully!");
                String out1 = "new list " + Arrays.toString(queueOne);
                System.out.println(out1);
                break;
            case 2:
                String[] duplicateTwo = new String[queueTwo.length];
                for (int i = 0, k = 0; i < queueTwo.length; i++) {
                    if (i != index) {
                        duplicateTwo[k] = String.valueOf((queueTwo[i]));
                        k++;
                    }
                }
                duplicateTwo[5] = "";
                queueTwo = duplicateTwo;
                System.out.println("\nRemoved the element successfully!");
                String out2 = "new list " + Arrays.toString(queueTwo);
                System.out.println(out2);
                break;
            case 3:
                String[] duplicateThree = new String[queueThree.length];
                for (int i = 0, k = 0; i < queueThree.length; i++) {
                    if (i != index) {
                        duplicateThree[k] = String.valueOf((queueThree[i]));
                        k++;
                    }
                }
                duplicateThree[5] = "";
                queueThree = duplicateThree;
                System.out.println("\nRemoved the element successfully!");
                String out3 = "new list " + Arrays.toString(queueThree);
                System.out.println(out3);
                break;
            default:
                System.out.println("Invalid Input");
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    /**
     * Checking if there are any empty spaces in the array
     */
    public static boolean checkIfEmpty(String[] array) {
        boolean out = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == "") {
                out = true;
            }
        }
        return out;
    }

    /**
     * Adding a new customer to a given fuel queue
     * input - queue number
     */

    public static void addCustomer(int num) {
        boolean loop = true;
        while (loop) {
            System.out.println("Enter Customers Name");
            String name = input.next();
            if (num == 1) {
                for (int i = 0; i < queueOne.length; i++) {
                    if (queueOne[i] == "") {
                        queueOne[i] = name;
                        break;
                    }
                }
                System.out.println("New queue -" + Arrays.toString(queueOne));
                break;
            } else if (num == 2) {
                for (int i = 0; i < queueTwo.length; i++) {
                    if (queueTwo[i] == "") {
                        queueTwo[i] = name;
                        break;
                    }
                }
                System.out.println("New queue -" + Arrays.toString(queueTwo));
                break;
            } else if (num == 3) {
                for (int i = 0; i < queueThree.length; i++) {
                    if (queueThree[i] == "") {
                        queueThree[i] = name;
                        break;
                    }
                }
                System.out.println("New queue -" + Arrays.toString(queueThree));
                break;
            } else {
                System.out.println("Invalid input please try again");
                System.out.println("Enter a valid number -1/2/3");
                num = input.nextInt();
                continue;
            }

        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void printSpacing() {
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Serving a customer
     * input - queue number
     */
    public static void serveCustomer(int queueNo) {
        switch (queueNo) {
            case 1:
                String[] duplicateOne = new String[queueOne.length];
                System.out.println(duplicateOne.length);
                for (int i = 0, k = 0; i < queueOne.length; i++) {
                    if (i != 0) {
                        duplicateOne[k] = String.valueOf((queueOne[i]));
                        k++;
                    }
                }
                duplicateOne[5] = "";
                queueOne = duplicateOne;
                System.out.println("\nServed the customer");
                fuelStock = fuelStock - 10;
                String RemainingF1 = fuelStock + "L remaining";
                System.out.println(RemainingF1);
                break;
            case 2:
                String[] duplicateTwo = new String[queueTwo.length];
                for (int i = 0, k = 0; i < queueTwo.length; i++) {
                    if (i != 0) {
                        duplicateTwo[k] = String.valueOf((queueTwo[i]));
                        k++;
                    }
                }
                duplicateTwo[5] = "";
                queueTwo = duplicateTwo;
                System.out.println("\nServed the customer");
                fuelStock = fuelStock - 10;
                String RemainingF2 = fuelStock + "L remaining";
                System.out.println(RemainingF2);
                break;
            case 3:
                String[] duplicateThree = new String[queueThree.length];
                for (int i = 0, k = 0; i < queueThree.length; i++) {
                    if (i != 0) {
                        duplicateThree[k] = String.valueOf((queueThree[i]));
                        k++;
                    }
                }
                duplicateThree[5] = "";
                queueThree = duplicateThree;
                fuelStock = fuelStock - 10;
                String RemainingF3 = fuelStock + "L remaining";
                System.out.println(RemainingF3);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Writing Data into File
     * References - https://www.geeksforgeeks.org/java-program-to-write-into-a-file/
     */
    public static void fileWrite() throws IOException, InterruptedException {


        // Defining the file name of the file
        Path fileName = Path.of("E://IIT//SEM 2//Java Programming//CW//fileWrite.txt");

        // Writing into the file
        Files.writeString(fileName,
                "\nRemaining_Fuel_Stock= " + fuelStock +

                //"\nNo of people in queue 1- " + (6 - count1) +
                "\nQueue1= " + Arrays.toString(queueOne) +

                //"\nNo of people in queue 2- " + (6 - count2) +
                "\nQueue2= " + Arrays.toString(queueTwo) +

                //"\nNo of people in queue 3- " + (6 - count3) +
                "\nQueue3= " + Arrays.toString(queueThree));
        System.out.println("                Storing Data Please wait");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("                Data stored successfully");
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Loading Data from File to console
     * References - https://www.geeksforgeeks.org/java-program-to-write-into-a-file/
     */
    public static void readFile() throws IOException, InterruptedException {

        Path fileName = Path.of("E://IIT//SEM 2//Java Programming//CW//fileWrite.txt");

        System.out.println("                Retrieving Data Please wait");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        TimeUnit.SECONDS.sleep(1);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    /**
     * Displaying Fuel Limit warning
     */
    public static void fuelWarning() {
        if (fuelStock == 500) {
            String msg = """
                                                    !!! Warning !!!
                                            Fuel stock has reached 500Liters
                    """;
            System.out.println(msg);
        }
    }


    //------------------------------------------------------------------------------------------------------------------

    /**
     * Sorting the queue according to the alphabetical order
     * input - array
     */
    public static void sortQueue(String[] array) {

        String tempV;
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[i].compareTo(array[j]) < 0) {
                    tempV = array[j];
                    array[j] = array[i];
                    array[i] = tempV;
                }
            }
            System.out.print(array[j]+" ");
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
      //------------------------------------------------------------------------------------------------------------------
    /**
     * Main Program
     */

    public static void main(String[] args) throws InterruptedException, IOException {
        boolean loop = true;
            while (loop) {
                try {
                System.out.println("""
                                    |********************************************MAIN MENU************************************************************************|
                                    |                          100 or VFQ:         View all Fuel Queues.                                                          |
                                    |                          101 or VEQ:         View all Empty Queues.                                                         |
                                    |                          102 or ACQ:         Add customer to a Queue.                                                       |
                                    |                          103 or RCQ:         Remove a customer from a Queue. (From a specific location).                    |
                                    |                          104 or PCQ:         Remove a served customer.                                                      |
                                    |                          105 or VCS:         View Customers Sorted in alphabetical order (Do not use library sort routine). |
                                    |                          106 or SPD:         Store Program Data into file.                                                  |
                                    |                          107 or LPD:         Load Program Data from file.                                                   |
                                    |                          108 or STK:         View Remaining Fuel Stock.                                                     |
                                    |                          109 or AFS:         Add Fuel Stock.                                                                |
                                    |                          999 or EXT:         Exit the Program.                                                              |
                                    |-----------------------------------------------------------------------------------------------------------------------------|""");
                System.out.println("Enter the number or the text code which you want to select");
                String option = input.next().toUpperCase();

                switch (option) {
                    case "100", "VFQ":
                        System.out.println(viewQueue());
                        printSpacing();
                        break;

                    case "101", "VEQ":
                        viewEmptyQueue();
                        printSpacing();
                        break;

                    case "102", "ACQ":
                        System.out.println("Enter the number of the queue\n" +
                                "1 -For queue one\n" +
                                "2 -For queue two\n" +
                                "3 -For queue three");
                        int queueNo = input.nextInt();
                        if (queueNo == 1) {
                            boolean condition = checkIfEmpty(queueOne);
                            if (condition == true) {
                                addCustomer(queueNo);
                            } else {
                                System.out.println("Queue is full");
                            }
                            printSpacing();
                            break;
                        } else if (queueNo == 2) {
                            boolean condition = checkIfEmpty(queueTwo);
                            if (condition == true) {
                                addCustomer(queueNo);
                            } else {
                                System.out.println("Queue is full");
                            }
                            printSpacing();
                            break;
                        } else if (queueNo == 3) {
                            boolean condition = checkIfEmpty(queueThree);
                            if (condition == true) {
                                addCustomer(queueNo);
                            } else {
                                System.out.println("Queue is full");
                            }
                            printSpacing();
                            break;
                        } else {
                            System.out.println("Invalid input please try again");
                            System.out.println("Enter a valid number -1/2/3");
                            break;

                        }

                    case "103", "RCQ":
                        System.out.println("Enter the number of the queue you want add a customer to\n" +
                                "1 -For queue one\n" +
                                "2 -For queue two\n" +
                                "3 -For queue three");
                        int queueNum = input.nextInt();
                        if (queueNum < 4) {
                            System.out.println("Queue " + queueNum + " selected ");
                            System.out.println("Enter the position you want to remove(1-6)");
                            int choice = input.nextInt();
                            removeCustomer(choice - 1, queueNum);
                            printSpacing();
                        } else {
                            System.out.println("Invalid Input");
                        }
                        break;


                    case "104", "PCQ":
                        boolean refillLoop = true;
                        while (refillLoop) {
                            fuelWarning();
                            System.out.println("Enter the Queue from which you want a serve a customer from \n1 -For Queue 1 \n2 -For Queue 3 \n3 -For Queue 3");
                            int choice = input.nextInt();
                            serveCustomer(choice);
                            System.out.println("\nDo you want serve another customer \nIf Yes enter Y \nIf No enter N");
                            String userInput = input.next();
                            if (userInput.equalsIgnoreCase("y")) {
                                continue;
                            } else if (userInput.equalsIgnoreCase("n")) {
                                refillLoop = false;
                                printSpacing();
                            } else {
                                System.out.println("Invalid Input");
                                continue;
                            }
                        }
                        break;

                    case "105", "VCS":
                        for (int i = 0; i < 6; i++){copyQ1[i] = queueOne[i];}
                        for (int i = 0; i < 6; i++){copyQ2[i] = queueTwo[i];}
                        for (int i = 0; i < 6; i++){copyQ3[i] = queueThree[i];}

                        for (int i = 0; i < mainQueue.length; i++) {
                            //System.out.println("\n");
                            System.out.print("Queue " + (i + 1) + ":");
                            sortQueue(mainQueue[i]);
                            System.out.println("\n");
                        }
                        printSpacing();
                        break;
                    case "106", "SPD":
                        fileWrite();
                        printSpacing();
                        break;
                    case "107", "LPD":

                        //System.out.println(readFileAsString("E://IIT//SEM 2//Java Programming//CW//fileWrite.txt"));
                        readFile();
                        printSpacing();
                        break;
                    case "108", "STK":

                        System.out.println("                                   Checking the remaining fuel stock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(fuelStock + "L remaining");
                        printSpacing();
                        break;

                    case "109", "AFS":

                        System.out.println("Enter the amount of fuel you want to restock");
                        int newStock = input.nextInt();
                        System.out.println(addFuel(newStock));
                        printSpacing();
                        break;

                    case "999", "EXT":

                        System.out.println("                                  Exiting the program");
                        loop = false;
                        printSpacing();
                        break;

                    default:
                        System.out.println("Invalid Input\n" + "Please Try again");
                        printSpacing();
                        break;
                }

        } catch (Exception e){
                    System.out.println("Error Please try again");
                }

    }
        System.out.println("Program Ended");
}
}


