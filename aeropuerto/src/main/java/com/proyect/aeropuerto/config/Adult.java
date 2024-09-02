package com.proyect.aeropuerto.config;

import java.time.LocalDate;

public class Adult {
    public boolean verify(String birthday) {
        LocalDate currentDate = LocalDate.now();
        int years = currentDate.minusYears(LocalDate.parse(birthday).getYear()).getYear();

        return years > 18;
    }
}
