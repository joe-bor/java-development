//package com.pluralsight.week9.jdbc.northwindShippers;
//
//import com.pluralsight.week9.jdbc.mini_exercises.DBConfig;
//import org.apache.commons.dbcp2.BasicDataSource;
//
//import java.sql.Array;
//import java.util.List;
//import java.util.Scanner;
//
//public class NorthwindShippers {
//    private final static Scanner SCANNER = new Scanner(System.in);
//    private final static BasicDataSource BASIC_DATA_SOURCE = initDataSource();
//
//    private static BasicDataSource initDataSource() {
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
//        basicDataSource.setUsername(DBConfig.get("db.user"));
//        basicDataSource.setPassword(DBConfig.get("db.password"));
//        return basicDataSource;
//    }
//
//    public static void main(String[] args) {
//        ShipperDAO shipperDAO = new ShipperDAO(BASIC_DATA_SOURCE);
//
//        // #1
//        String[] details = promptForNewShipper();
//        shipperDAO.addNewShipper(details[0], details[1]);
//
//        // #2
//        displayList(shipperDAO.getAllShippers());
//
//        // #3
//        promptToUpdate();
//
//        // #4
//        displayList(shipperDAO.getAllShippers());
//
//        // #5
//        promptToDelete();
//
//        // #6
//        displayList(shipperDAO.getAllShippers());
//    }
//
//    private static String[] promptForNewShipper(){
//        System.out.println("Provide the following data:");
//        System.out.print("Company name: ");
//        String companyName = SCANNER.nextLine();
//        System.out.print("Phone: ");
//        String phoneNumber = SCANNER.nextLine();
//
//        return new String[]{companyName, phoneNumber};
//
//    }
//
//    private static void promptToUpdate(){
//        System.out.println("\nUpdating a shipper...");
//        System.out.print("Please provide the id: ");
//        int id = SCANNER.nextInt();
//        SCANNER.nextLine();
//        System.out.print("Please provide the new phone number: \n");
//        String phoneNumber = SCANNER.nextLine();
//
//        ShipperDAO shipperDAO = new ShipperDAO(BASIC_DATA_SOURCE);
//        shipperDAO.updateShipper(id, phoneNumber);
//
//    }
//
//    private static void promptToDelete(){
//        System.out.println("Please provide the id of the shipper you want to delete");
//        int id = SCANNER.nextInt();
//        SCANNER.nextLine();
//
//        ShipperDAO shipperDAO = new ShipperDAO(BASIC_DATA_SOURCE);
//        shipperDAO.deleteShipper(id);
//    }
//
//    private static <T> void displayList(List<T> list){
//        list.forEach(System.out::println);
//    }
//
//}
