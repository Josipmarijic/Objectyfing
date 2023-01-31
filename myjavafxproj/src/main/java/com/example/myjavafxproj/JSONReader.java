package com.example.myjavafxproj;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class JSONReader {

    File file = new File("C:\\Users\\j__ma\\IdeaProjects\\myjavafxproj\\src\\main\\java\\com\\example\\myjavafxproj\\sample.json");

    //Skapar en metod som returnerar en arraylist med mina customers
    public ArrayList<Customer> parsJson() {

        ArrayList<Customer> customers = new ArrayList<>();

        JSONArray jsonArray;

        try {

            Reader reader = new FileReader(file);
            //Detta är JSONsimple inte helt hundra på hur det funkar men det funkar
            JSONParser parser = new JSONParser();

            jsonArray = (JSONArray) parser.parse(reader);


            JSONObject jsonObject;
            //Skapar en loop som loopar igeom min jsonarray och därefter hämtar jag datan jag vill ha
            //och lägger till det i min customer class med mina setters
            for (int i = 0; i < jsonArray.size(); i++) {

                jsonObject = (JSONObject) jsonArray.get(i);
                Customer customer = new Customer();

                customer.setOrderDate((String) jsonObject.get("OrderDate"));
                customer.setRegion((String) jsonObject.get("Region"));
                customer.setRep1((String) jsonObject.get("Rep1"));
                customer.setRep2((String) jsonObject.get("Rep2"));
                customer.setItem((String) jsonObject.get("Item"));
                customer.setUnit(jsonObject.get("Units").toString());
                customer.setCost((String) jsonObject.get("UnitCost"));
                customer.setTotal(customer.getCost() * customer.getUnit());


                customers.add(customer);
            }

        } catch (IOException | ParseException e1) {
            e1.printStackTrace();
        }

        return customers;

    }


}
