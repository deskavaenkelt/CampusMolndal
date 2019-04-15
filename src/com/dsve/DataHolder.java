package com.dsve;
/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/

import java.util.ArrayList;

/**
 * datalogiUppgift2Primtal
 *
 * @author Lars Strömberg
 * @version 1.0
 * @since 2019-02-13
 * https://github.com/deskavaenkelt/
 */
class DataHolder {
    // Håller min databas som bara kan modifieras via denna klassen
    private ArrayList<String> dataHolder = new ArrayList<>();

    void addDatahHolderItem(String item) {
        dataHolder.add(item);
    }

    ArrayList<String> getDataHolder() {
        return dataHolder;
    }

    boolean isDuplicate(int numberToBeChecked) {
        // Kolla om numberToBeChecked redan finns i databasen
        for (String s : dataHolder) {
            if (Integer.parseInt(s) == numberToBeChecked) {
                System.out.println("The given input already exists");
                return true;
            }
        }
        return false;
    }

    // Söker reda på om ett tal finns i databasen och kontrollerar samtidigt vad som är närmast
    void searchFor(int numberToBeChecked) {
        int distance = Integer.MAX_VALUE;
        int idClosest= 0;
        int newDistance;

        for (int i = 0; i < dataHolder.size(); i++) {
            // Går igenom databasen och kollar om numberToBeChecked finns i databasen
            int temp = Integer.parseInt(dataHolder.get(i));
            if (temp == numberToBeChecked) {
                System.out.println(dataHolder.get(i) + " was found");
                return;
            }

            // Kollar samtidigt hur långt avståndet är från inmatat tal till kontrollerat tal, sparar id om det nya avståndet är kortast
            newDistance = Math.abs(numberToBeChecked - temp);   // Extra
            if (newDistance < distance) {
                idClosest = i;
                distance = newDistance;
            }
        }

        System.out.println(numberToBeChecked + " was not found");

        System.out.println("Closest number is: " + dataHolder.get(idClosest));
    }
}
