package com.pluralsight.week5;

public abstract class NameFormatter {

    private NameFormatter() {}

    public static String format(String firstName, String lastName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (firstName.trim().isBlank() || lastName.trim().isBlank()) {
                throw new IllegalArgumentException("First Name and Last Name are Required!");
            }

            stringBuilder.append(lastName.trim());
            stringBuilder.append(" ");
            stringBuilder.append(firstName.trim());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return stringBuilder.toString();
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        var stringBuilder = new StringBuilder();
        try {
            prefix.trim();
            firstName.trim();
            middleName.trim();
            lastName.trim();
            suffix.trim();

            if (firstName.isBlank() || lastName.isBlank()) {
                throw new IllegalArgumentException("First Name and Last Name are Required!");
            }

            stringBuilder.append(lastName + ", ");
            stringBuilder.append(prefix.isBlank() ? "" : prefix + " ");
            stringBuilder.append(firstName + " ");
            stringBuilder.append(middleName.isBlank() ? "" : middleName + ", ");
            stringBuilder.append(suffix.isBlank() ? "" : suffix);

        } catch (IllegalArgumentException e) {
            System.err.println(e);
            return null;
        }
        return stringBuilder.toString();


    }

    public static String format(String fullName){
        String[] fullNameArr = fullName.trim().split(" ");

        return switch (fullNameArr.length){
            case 2 -> format(fullNameArr[0], fullNameArr[1]);
            case 4 -> format(fullNameArr[0], fullNameArr[1], fullNameArr[2], fullNameArr[3], "");
            case 5 -> format(fullNameArr[0], fullNameArr[1], fullNameArr[2], fullNameArr[3], fullNameArr[5]);
            default -> null;
        };
    }
}
