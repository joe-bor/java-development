package com.pluralsight.week9.jdbc.northwindShippers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shipper {
    private int shipperID;
    private String companyName;
    private String phoneNumber;
}
