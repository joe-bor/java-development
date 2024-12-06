package com.pluralsight.week10.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    USER("Dont break the application please"),
    ADMIN("Be Responsible"),
    EDITOR("Be creative");

    private String permissions;
}
