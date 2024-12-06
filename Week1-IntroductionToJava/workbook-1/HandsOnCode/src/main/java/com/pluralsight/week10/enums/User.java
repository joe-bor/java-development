package com.pluralsight.week10.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public static void main(String[] args) {
        var x = new User("user x", UserRole.USER);
        var y = new User("user y", UserRole.ADMIN);
        var z = new User("user z", UserRole.EDITOR);

        x.printRole();
        x.printPermissions();

        y.printRole();
        y.printPermissions();

        z.printRole();
        z.printPermissions();
    }


    private String userName;
    private UserRole userRole;

    public void printRole(){
        System.out.println(this.userRole);
    }

    public void printPermissions(){
        String permissions = switch (this.userRole){
            case USER  -> "You are a user. Dont break the app";
            case ADMIN -> "You are an admin. Be responsible";
            case EDITOR -> "You are an editor. Be creative";
        };
        System.out.println(permissions);
    }
}
