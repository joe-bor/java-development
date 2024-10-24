package com.pluralsight.week5;

public class NameFormatter {

    private NameFormatter() {
    }

    public static String format(String firstName, String lastName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (firstName.trim().isBlank() || lastName.trim().isBlank()) {
                throw new IllegalArgumentException("First Name and Last Name are Required!");
            }

            stringBuilder.append(firstName.trim());
            stringBuilder.append(" ");
            stringBuilder.append(lastName.trim());

        } catch (IllegalArgumentException e) {
            System.err.println(e);
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
        }
        return stringBuilder.toString();

    }
}
