package com.pluralsight.week9.jdbc.sakila;

import com.pluralsight.week9.jdbc.mini_exercises.DBConfig;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final BasicDataSource BASIC_DATA_SOURCE = initDataSource();

    public static void main(String[] args) {
        SakilaDataManager sakilaDataManager = new SakilaDataManager(BASIC_DATA_SOURCE);

        String firstName = promptForFirstName();
        String lastName = promptForLastName();
        var actors = sakilaDataManager.getAllActorsWithGivenName(firstName, lastName);
        displayList(actors);

        int actorID = promptForActorId();
        var filmsByActorID = sakilaDataManager.getAllFilmsViaActorID(actorID);
        displayList(filmsByActorID);

    }

    private static BasicDataSource initDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        basicDataSource.setUsername(DBConfig.get("db.user"));
        basicDataSource.setPassword(DBConfig.get("db.password"));
        return basicDataSource;
    }

    static <T> void displayList(List<T> list){
        list.forEach(System.out::println);
    }

    private static String promptForFirstName(){
        System.out.print("Enter the first name: ");
        return SCANNER.nextLine();
    }

    private static String promptForLastName(){
        System.out.print("Enter the last name: ");
        return SCANNER.nextLine();
    }

    private static int promptForActorId(){
        System.out.print("Provide the id of the actor you want to see the films of: ");
        int actorID = SCANNER.nextInt();
        SCANNER.nextLine();

        return actorID;
    }

}
