package com.example.myjavafxproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public ArrayList<Customer> customers = new ArrayList<>();
    File file = new File("C:\\Users\\j__ma\\IdeaProjects\\myjavafxproj\\src\\main\\java\\com\\example\\myjavafxproj\\sample.csv");

    public ArrayList<Customer> readCSV() {

        {
            Scanner scanner;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ArrayList rows = new ArrayList<>();
            //Läser filen och sparar alla rader i en arraylist
            while (scanner.hasNextLine()) {
                rows.add(scanner.nextLine());
            }
            //Skapar en loop som splitar arrayen på alla "," och jag vet vilken index som är datan jag vill ha och lägger
            // till dom till min customer med setters. Jag gör det på alla förutom total. För att filen avslutas utan total.
            //Annars får jag fel för sista raden har ett minde index än alla andra.
            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i).toString().split(",");
                Customer customer = new Customer();
                customer.setOrderDate(row[0]);
                customer.setRegion(row[1]);
                customer.setRep1(row[2]);
                customer.setRep2(row[3]);
                customer.setItem(row[4]);
                customer.setUnit(row[5]);
                customer.setCost(row[6]);
                customer.setTotal(customer.getUnit() * customer.getCost());


                customers.add(customer);


            }
            //Använda bara det här för att läsa att jag fick rätt data
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i).getOrderDate());
                System.out.println(customers.get(i).getRegion());

            }


        }


        return customers;
    }


}

