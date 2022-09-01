package com.rd.written.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AccountLoader {

    public static List<Account> loadFile(String path) throws IOException {
        return Files.readAllLines(Path.of(path)).stream()
                .map(line -> line.split(";"))
                .filter(array -> array.length == 5)
                .map(array -> {
                    try {
                        return Account.builder()
                                .number(array[0])
                                .balance(new BigDecimal(array[1]))
                                .balanceDate(LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4])))
                                .build();
                    }catch (NumberFormatException | DateTimeException e){
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
