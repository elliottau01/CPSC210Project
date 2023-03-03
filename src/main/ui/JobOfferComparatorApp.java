package ui;

import model.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static model.JobOffer.calculateTotalSalary;

//For this class, I (Elliott Au) took reference of the TellerApp project and
// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp

public class JobOfferComparatorApp {
    private JobOffer jobOffer;
    private JobOfferList jobOfferList;
    private Scanner input;
    private City city;
    private CityList cityList;
    String companyName;
    String jobPosition;
    String jobLocation;
    double annualSalary;
    double signingBonus;
    int stockAmount;
    double stockPriceCurrent;
    String cityName;
    String countryName;
    double livingExpenses;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/myFile2.json";

    //EFFECTS: runs the teller application
    public JobOfferComparatorApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        cityList = new CityList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runComparator();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runComparator() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("0")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command)  {
        if (command.equals("1")) {
            addJobOffer();
        } else if (command.equals("2")) {
            removeJobOffer();
        } else if (command.equals("3")) {
            showJobOfferList();
        } else if (command.equals("4")) {
            findBestJobOffer();
        } else if (command.equals("5")) {
            calTotalSalaryConsole();
        } else if (command.equals("6")) {
            addCityInfo();
        } else if (command.equals("7")) {
            removeCityInfo();
        } else if (command.equals("8")) {
            showCityList();
        } else if (command.equals("9")) {
            saveCityList();
        } else if (command.equals("10")) {
            loadCityList();
        } else {
            System.out.println("Not a valid input...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        jobOfferList = new JobOfferList();
        cityList = new CityList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> Add Job Offer");
        System.out.println("\t2 -> Remove Job Offer");
        System.out.println("\t3 -> Show all JobOffers in the list");
        System.out.println("\t4 -> Find the Best Job Offer");
        System.out.println("\t5 -> Calculate the total annual salary of 1 Job Offer");
        System.out.println("\t6 -> Add City Info");
        System.out.println("\t7 -> Remove City Info");
        System.out.println("\t8 -> Show all cities in the list");
        System.out.println("\t0 -> Quit");
        System.out.println("\tSJ -> Save JobOfferList");
        System.out.println("\tLJ -> Load JobOfferList");
        System.out.println("\t9 -> Save CityList");
        System.out.println("\t10 -> Load CityList");

    }

    // MODIFIES: JobOfferList
    // EFFECTS: Construct a Job Offer, adds that Job Offer to the JobOfferList
    private void addJobOffer() {

        System.out.print("Add Job Offer");

        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");
        companyName = input.next();

        System.out.println("Please input the job position");
        jobPosition = input.next();

        System.out.println("Please input the job location");
        jobLocation = input.next();

        System.out.println("Please input your annual salary");
        annualSalary = input.nextDouble();

        System.out.println("Please input your signing bonus");
        signingBonus = input.nextDouble();

        System.out.println("Please input the amount of stocks provided");
        stockAmount = input.nextInt();

        System.out.println("Please input the current stock price");
        stockPriceCurrent = input.nextDouble();

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        jobOfferList.addJobOffer(jobOffer);

        System.out.println("The Job Offer has been added to the list successfully!");

    }


    // MODIFIES: JobOfferList
    // EFFECTS: Construct a Job Offer, then removes that Job Offer from the JobOfferList
    private void removeJobOffer() {

        System.out.println("Remove Job Offer");
        System.out.println("Please input which job offer you would like to remove");

        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");
        companyName = input.next();

        System.out.println("Please input the job position");
        jobPosition = input.next();

        System.out.println("Please input the job location");
        jobLocation = input.next();

        System.out.println("Please input your annual salary");
        annualSalary = input.nextDouble();

        System.out.println("Please input your signing bonus");
        signingBonus = input.nextDouble();

        System.out.println("Please input the amount of stocks provided");
        stockAmount = input.nextInt();

        System.out.println("Please input the current stock price");
        stockPriceCurrent = input.nextDouble();

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        jobOfferList.removeJobOffer(companyName, jobPosition, jobLocation);

        System.out.println("The Job Offer is removed from the list successfully!");

    }


    // EFFECTS: find the best Job Offer in the JobOfferList
    private void findBestJobOffer() {
        System.out.println("Find the Best Job Offer");
        System.out.println(jobOfferList.maxSalaryJobOffer());
    }


    //EFFECTS: calculate the total salary of the JobOffer
    private void calTotalSalaryConsole() {
        System.out.println("Calculate the total annual salary");
        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");
        companyName = input.next();

        System.out.println("Please input the job position");
        jobPosition = input.next();

        System.out.println("Please input the job location");
        jobLocation = input.next();

        System.out.println("Please input your annual salary");
        annualSalary = input.nextDouble();

        System.out.println("Please input your signing bonus");
        signingBonus = input.nextDouble();

        System.out.println("Please input the amount of stocks provided");
        stockAmount = input.nextInt();

        System.out.println("Please input the current stock price");
        stockPriceCurrent = input.nextDouble();

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        System.out.println("The total annual salary of being a " + jobOffer.getJobPosition()
                + " at " + jobOffer.getCompanyName() + " in " + jobOffer.getJobLocation() + " is "
                + calculateTotalSalary(jobOffer));

    }

    //MODIFIES: CityList
    //EFFECTS: add the City from the list
    private void addCityInfo() {

        System.out.println("Add city information: City Name, Country Name, "
                + "Living Expenses with rent per month (for 1 person only)");

        System.out.println("Please input the name of the City");
        cityName = input.next();

        System.out.println("Please input the country (USA or CA)");
        countryName = input.next();

        System.out.println("Please input the living expenses with rent per month (for 1 person only)");
        livingExpenses = input.nextDouble();

        City city = new City(cityName, countryName, livingExpenses);

        cityList.addCityToList(city);

        System.out.println("The city info is added successfully!");

    }

    //MODIFIES: CityList
    //EFFECTS: remove the City from the list
    private void removeCityInfo() {

        System.out.println("Add city information: City Name, Country Name, "
                + "Living Expenses with rent per month (for 1 person only)");

        System.out.println("Please input the name of the City");
        cityName = input.next();

        System.out.println("Please input the country (USA or CA)");
        countryName = input.next();

        System.out.println("Please input the living expenses with rent per month (for 1 person only)");
        livingExpenses = input.nextDouble();

        City city = new City(cityName, countryName, livingExpenses);

        cityList.removeCityToList(cityName, countryName);

        System.out.println("The city info is removed successfully!");

    }

    //EFFECTS: Show the company name, job position and job location of the job offer
    private void showJobOfferList() {
        System.out.println(jobOfferList.showJobOfferCompanyAndPosition());
        System.out.println("All Job Offers have been listed");
    }

    //EFFECTS: Show the name of the cities in the cityList
    private void showCityList() {
        System.out.println(cityList.showCityName());
        System.out.println("All city names have been listed");
    }

    // EFFECTS: saves the workroom to file
    private void saveCityList() {
        try {
            jsonWriter.open();
            jsonWriter.write(cityList);
            jsonWriter.close();
            System.out.println("Saved city list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadCityList() {
        try {
            cityList = jsonReader.read();
            System.out.println("Loaded city list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



}

