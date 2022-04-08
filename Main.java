package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.company.Category.*;

public class Main {
    public static ArrayList<BluRayItem> allBluRays = new ArrayList<>();
    public static void main(String[] args) {

        ArrayList<BluRayItem> allBluRays = loadBluRays();
        // write your code here
        int menuSelection = 3;
        int directorySelection = 3;
        System.out.println("Hello, welcome to the Blu-Ray Database.");
        // The label loop code retrieved from https://stackoverflow.com/questions/60023456/how-to-go-back-to-previous-switch
        theLabel:
        while (true) {
            //end of adapted code

            Scanner userInput = new Scanner(System.in);
            if (menuSelection >= 4) {
                System.out.println("\n" + "Sorry Incorrect Number. Please try options 1 - 3" + "\n");
            }
            while (menuSelection > 0 && menuSelection < 4 || true) {

                System.out.println("Please press the following options: " + "\n" + "[ 1 ] See list of added Blu-Rays. " + "\n" + "[ 2 ] Add a Blu-Ray." + "\n" + "[ 3 ] Exit" + "\n");

                    try {
                        Scanner userInput2 = new Scanner(System.in);
                        menuSelection = userInput2.nextInt();
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a number.");
                    }
                }
                        switch (menuSelection) {
                            case 1:

                                while (directorySelection > 0 && directorySelection < 4 || true) {
                                    System.out.println("Blu-Ray Database - Directory");
                                    System.out.println("Please press the following options: " + "\n" + "[ 1 ] See list of added Blu-Rays. " + "\n" + "[ 2 ] See Blu-Ray By Genre." + "\n" + "[ 3 ] Back" + "\n" + "[ 4 ] Exit)" + "\n");
                                    try {
                                        Scanner userInput3 = new Scanner(System.in);
                                        directorySelection = userInput3.nextInt();

                                        break;
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("Please enter a number.");
                                    }
                                }if (directorySelection >= 4) {
                                System.out.println("Sorry Incorrect Number. Please try options 1 - 4");
                                }
                                    switch (directorySelection) {
                                        case 1:
                                            for (BluRayItem bluRay : allBluRays) {
                                                System.out.println(bluRay.getName() + ", " + bluRay.getCategory() + ", " + bluRay.getYear());
                                            }
                                            break;
                                        case 2:
                                            genre(allBluRays);
                                            break;
                                        // The Label loop code retrieved from https://stackoverflow.com/questions/60023456/how-to-go-back-to-previous-switch
                                        case 3:
                                            System.out.println("Blu-Ray Database - Home");
                                            continue theLabel;
                                            // end of adapted code
                                        case 4:
                                            System.out.println("Exiting...");
                                            System.exit(0);
                                            break;

                                        default:
                                            break;
                                    }

                                break;
                            case 2:
                                addBluRay(allBluRays);
                                break;
                            case 3:
                                System.out.println("Exiting...");
                                System.exit(0);
                            default:
                                break;
                        }
                    }

                }

    public static void saveBluRays(ArrayList<BluRayItem> allBluRays) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("blurays.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(allBluRays);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Unable to create object output stream" + e.getMessage());
        }
    }

    static public ArrayList<BluRayItem> loadBluRays() {
        try {
            FileInputStream fileInputStream = new FileInputStream("blurays.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<BluRayItem> allBlueRays = (ArrayList<BluRayItem>) objectInputStream.readObject();
            return allBlueRays;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error converting data to object" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find class representing saved object " + e.getMessage());
        }
        return new ArrayList<BluRayItem>();
    }

    public static void genreText() {
        System.out.println("Please Enter the Genre");
        System.out.println("[ 1 ] Horror" + "\n" + "[ 2 ] Action" + "\n" + "[ 3 ] Drama" + "\n" + "[ 4 ] Romantic" + "\n" + "[ 5 ] Comedy" + "\n" + "[ 6 ] Adventure" + "\n" + "[ 7 ] Musicals" + "\n" + "[ 8 ] Documentary" + "\n" + "[ 9 ] Animation\"" + "\n" + "[ 10 ] Crime" + "\n" + "[ 11 ] Fantasy" + "\n" + "[ 12 ] Sci-Fi" + "\n");
    }


     static void genre(ArrayList<BluRayItem> allBluRays) {
        genreText();
        int genre = 13;
        while (true) {
            Scanner userInput = new Scanner(System.in);
            try {
                genre = userInput.nextInt();
                while (genre >= 13) {
                    System.out.println("Please enter a valid selection.");
                    genre = userInput.nextInt();
                }
                switch (genre) {
                    case 1:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Horror + ", " + bluRay.getYear());
                        }
                        break;
                    case 2:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Action + ", " + bluRay.getYear());
                        }
                        break;
                    case 3:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Drama + ", " + bluRay.getYear());
                        }
                        break;
                    case 4:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Romantic + ", " + bluRay.getYear());
                        }
                        break;
                    case 5:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Comedy + ", " + bluRay.getYear());
                        }
                        break;
                    case 6:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Adventure + ", " + bluRay.getYear());
                        }
                        break;
                    case 7:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Musicals + ", " + bluRay.getYear());
                        }
                        break;
                    case 8:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Documentary + ", " + bluRay.getYear());
                        }
                        break;
                    case 9:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Animation + ", " + bluRay.getYear());
                        }
                        break;
                    case 10:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Crime + ", " + bluRay.getYear());
                        }
                        break;
                    case 11:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + Fantasy + ", " + bluRay.getYear());
                        }
                        break;
                    case 12:
                        for (BluRayItem bluRay : allBluRays) {
                            System.out.println(bluRay.getName() + ", " + SciFi + ", " + bluRay.getYear());
                        }
                        break;

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            } finally {
                break;
            }
        }

    }

    public static void addBluRay(ArrayList<BluRayItem> allBluRays) {
        System.out.println("Blu-Ray Database - Add A New Blu-Ray" + "\n");
        int genre;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please Enter the title");
        String title = userInput.nextLine();
        genreText();
        while (true) {
            Scanner userInput2 = new Scanner(System.in);
            try {
               Category category;
                genre = userInput2.nextInt();
                while (genre >= 13) {
                    System.out.println("Please enter a valid selection.");
                    genre = userInput2.nextInt();
                }
                switch (genre) {
                    case 1:
                        category = Horror;
                        break;
                    case 2:
                        category = Action;
                        break;
                    case 3:
                        category = Drama;
                        break;
                    case 4:
                        category = Romantic;
                        break;
                    case 5:
                        category = Comedy;
                        break;
                    case 6:
                        category = Adventure;
                        break;
                    case 7:
                        category = Musicals;
                        break;
                    case 8:
                        category = Documentary;
                        break;
                    case 9:
                        category = Animation;
                        break;
                    case 10:
                        category = Crime;
                        break;
                    case 11:
                        category = Fantasy;
                        break;
                    case 12:
                        category = SciFi;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + genre);

                }
                System.out.println("Please Enter the Year of release");
                int year = userInput.nextInt();
                while (year < 1900 || year > 2021) {
                    System.out.println("Please enter a valid year.");
                    year = userInput.nextInt();
                }
                BluRayItem userBluRay = new BluRayItem(title, category, year);
                allBluRays.add(userBluRay);
                saveBluRays(allBluRays);
                System.out.println("Saved!");
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}