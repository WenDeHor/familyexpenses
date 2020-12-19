package com.example.familyexpenses.utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {
    //TODO The first solution
//    public static void main(String[] args) {
//        String address1 = "555 Straight Stave Ave, San Francisco, CA 94104";
//        String address2 = "444 Ave Maria Stairway St., San Francisco, CA 94104";
//        String address3 = "9032 Flave Steep Str, San Francisco, CA 94104";
//        String[] addressList = {address1, address2, address3};
//        System.out.println("Input data:");
//        System.out.println(address1);
//        System.out.println(address2);
//        System.out.println(address3 + "\n");
//        System.out.println("Result:");
//        for (int i = 0; i < addressList.length; i++) {
//            String a = addressList[i].replaceAll("Ave,|Ave.,", "Avenue,").replaceAll("Str,|Str.,|St,|St.,", "Street,");
//            System.out.println(a);
//        }
//    }

    //TODO The second solution
    public static void main(String[] args) {
        List collection = Arrays.asList(
                "555 Straight Stave Ave, San Francisco, CA 94104",
                "444 Ave Maria Stairway St., San Francisco, CA 94104",
                "9032 Flave Steep Str, San Francisco, CA 94104");

        for (int i = 0; i < collection.size(); i++) {
            Pattern p = Pattern.compile("(Ave,|Ave.,)");
            Pattern p2 = Pattern.compile("(Str,|Str.,|St,|St.,)");
            Matcher m = p.matcher((CharSequence) collection.get(i));
            Matcher m2 = p2.matcher((CharSequence) collection.get(i));
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "Avenue,");
                m.appendTail(sb);
                System.out.println(sb);
            }

            while (m2.find()) {
                m2.appendReplacement(sb, "Street,");
                m2.appendTail(sb);
                System.out.println(sb);
            }
        }
    }
}





