package com.avaneesh.bfhl_java_assignment.service.impl;

import com.avaneesh.bfhl_java_assignment.dto.BfhlRequest;
import com.avaneesh.bfhl_java_assignment.dto.BfhlResponse;
import com.avaneesh.bfhl_java_assignment.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        int sum = 0;
        StringBuilder alphabetConcat = new StringBuilder();
        for (String item : request.getData()) {
            if (item.matches("\\d+")) {
                int number = Integer.parseInt(item);
                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            }
            else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphabetConcat.append(item);
            }
            else {

                specialCharacters.add(item);
            }
        }
        String concatString =
                createAlternatingCapsString(
                        alphabetConcat.reverse().toString()
                );

        return new BfhlResponse(
                true,
                "avaneesh_malviya_19062005",
                "avaneeshmalviya230577@acropolis.in",
                "0827CS231055",
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
        );
    }

    private String createAlternatingCapsString(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }
        return result.toString();
    }
}
