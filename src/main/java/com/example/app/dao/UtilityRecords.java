package com.example.app.dao;

import com.example.app.controllers.DBController;
import com.example.app.model.Building;
import com.example.app.model.Utility;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class UtilityRecords implements DBQueries {
    private DBController dbController;
    private ArrayList<Utility> utilities = new ArrayList<>();
    private ResultSet resultSet;

    public UtilityRecords(DBController dbController) {
        this.dbController = dbController;
    }

    public ArrayList<Utility> getUtilities(int buildingID, LocalDate start, LocalDate end) {
        Connection connection = dbController.getConnection();
        if (connection == null) {
            System.out.println("No active database connection.");
            return utilities; // would return empty
        }

        String query = "SELECT * FROM utility "
                     + "WHERE buildingID = ? "
                     + "AND date >= ? AND date <= ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, buildingID);
            statement.setDate(2, Date.valueOf(start));
            statement.setDate(3, Date.valueOf(end));

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Utility utility = new Utility();

                utility.setUtilityID(resultSet.getInt("utilityID"));
                utility.setUtilityID(resultSet.getInt("buildingID"));
                utility.setDate(resultSet.getDate("date"));
                utility.setElectricityCost(resultSet.getFloat("e_cost"));
                utility.setWaterCost(resultSet.getFloat("w_cost"));
                utility.setSewageCost(resultSet.getFloat("sw_cost"));
                utility.setMiscCost(resultSet.getFloat("misc_cost"));
                utility.setElectricityUsage(resultSet.getFloat("e_usage"));
                utility.setWaterUsage(resultSet.getFloat("w_usage"));
                utility.setUsageGal(resultSet.getFloat("usage_gal"));
                utility.setUsageKwh(resultSet.getFloat("usage_kwh"));

                utilities.add(utility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Caught SQL Error: %s", e);
        }

        return utilities;
    }
}
