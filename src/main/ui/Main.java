package ui;

import javax.swing.*;
import java.awt.desktop.QuitEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//For the Main class, I (Elliott Au) took reference of the TellerApp project and the JSON Workroom sample project
// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//Link of the Workroom project: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class Main extends JFrame implements ActionListener {

    static JButton Quit;
    static JButton SaveCity;
    static JButton SaveJob;
    static JButton LoadCity;
    static JButton LoadJob;
    static JButton AddJob;
    static JButton AddCity;
    static JButton ShowAllJobs;
    static JButton ShowAllCities;
    static JButton RemoveJob;
    static JButton RemoveCity;

    public static void main(String[] args) {

        JFrame frame = new JFrame("YourJobComparator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

        Quit = new JButton();
        Quit.setBounds(50, 50, 100,40);
        Quit.setText("Quit");
        frame.add(Quit);

        LoadJob = new JButton();
        LoadJob.setBounds(50, 120, 100,40);
        LoadJob.setText("LoadJob");
        frame.add(LoadJob);

        SaveJob = new JButton();
        SaveJob.setBounds(50, 160, 100,40);
        SaveJob.setText("SaveJob");
        frame.add(SaveJob);

        AddJob = new JButton();
        AddJob.setBounds(50,200,100,40);
        AddJob.setText("AddJob");
        frame.add(AddJob);

        RemoveJob = new JButton();
        RemoveJob.setBounds(50,240,100,40);
        RemoveJob.setText("RemoveJob");
        frame.add(RemoveJob);

        ShowAllJobs = new JButton();
        ShowAllJobs.setBounds(50, 280, 100,40);
        ShowAllJobs.setText("ShowAllJobs");
        frame.add(ShowAllJobs);


        LoadCity = new JButton();
        LoadCity.setBounds(50, 350, 100,40);
        LoadCity.setText("LoadCity");
        frame.add(LoadCity);

        SaveCity = new JButton();
        SaveCity.setBounds(50,390, 100,40);
        SaveCity.setText("SaveCity");
        frame.add(SaveCity);

        AddCity = new JButton();
        AddCity.setBounds(50, 430, 100,40);
        AddCity.setText("AddCity");
        frame.add(AddCity);

        RemoveCity = new JButton();
        RemoveCity.setBounds(50,470,100,40);
        RemoveCity.setText("RemoveCity");
        frame.add(RemoveCity);

        ShowAllCities = new JButton();
        ShowAllCities.setBounds(50, 510, 100,40);
        ShowAllCities.setText("ShowAllCities");
        frame.add(ShowAllCities);



        try {
            new JobOfferComparatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}