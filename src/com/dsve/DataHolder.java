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
public class DataHolder {

    private ArrayList<String> dataHolder = new ArrayList<>();

    public void addDatahHolderItem(String item) {
        dataHolder.add(item);
    }


    public ArrayList<String> getDataHolder() {
        return dataHolder;
    }

    public boolean isDuplicate(int numberToBeChecked) {
        for (int i = 0; i < dataHolder.size(); i++) {
            if (Integer.parseInt(dataHolder.get(i)) == numberToBeChecked) {
                System.out.println("The given input already exists");
                return true;
            }
        }
        return false;
    }

    public void searchFor(int numberToBeChecked) {
        int distance = Integer.MAX_VALUE;
        int idClosest= 0;
        int newDistance = 0;
        for (int i = 0; i < dataHolder.size(); i++) {
            int temp = Integer.parseInt(dataHolder.get(i));
            if (temp == numberToBeChecked) {
                System.out.println(dataHolder.get(i) + " was found");
                return;
            }

            newDistance = Math.abs(numberToBeChecked - temp);   // Extra
            if (newDistance < distance) {
                idClosest = i;
                distance = newDistance;
            }
        }

        System.out.println(numberToBeChecked + " was not found");

        System.out.println("Closest number is: " + dataHolder.get(idClosest));
    }

    public void clearArrayList() {
        dataHolder.remove(dataHolder);
    }
}
