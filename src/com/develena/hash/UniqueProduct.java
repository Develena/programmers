package com.develena.hash;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        String result = null;
        List<String> prds = Arrays.stream(products).sorted().collect(Collectors.toList());
        for (int i = 0; i < prds.size(); i++) {
            if(prds.get(i) != prds.get(i-1) && prds.get(i) != prds.get(i+1)){
                result =  prds.get(i);
                break;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}
