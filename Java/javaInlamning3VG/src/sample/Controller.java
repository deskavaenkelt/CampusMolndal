/*
  __
 /\ \
 \_\ \    ____  __  __     __
 /'_` \  /',__\/\ \/\ \  /'__`\
/\ \L\ \/\__, `\ \ \_/ |/\  __/
\ \___,_\/\____/\ \___/ \ \____\
 \/__,_ /\/___/  \/__/   \/____/

*/
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;


public class Controller {

    // Movie Id
    @FXML
    private RadioButton movieId0;
    @FXML
    private RadioButton movieId1;
    @FXML
    private RadioButton movieId2;
    @FXML
    private RadioButton movieId3;


    // Number of Tickets ordered
    @FXML
    private RadioButton ticketsOrdered1;
    @FXML
    private RadioButton ticketsOrdered2;
    @FXML
    private RadioButton ticketsOrdered3;
    @FXML
    private RadioButton ticketsOrdered4;
    @FXML
    private RadioButton ticketsOrdered5;
    @FXML
    private RadioButton ticketsOrdered6;
    @FXML
    private RadioButton ticketsOrdered7;
    @FXML
    private RadioButton ticketsOrdered8;


    // Send the sum to this Label
    @FXML
    private Label totalPrice;


    // Make the calculation when the button is pressed
    @FXML
    public void onButtonClicked() {
        int sum = moviePrice() * numberOfTicketsOrdered();
        String stringSum = Integer.toString(sum);
        totalPrice.setText(stringSum);
        System.out.println(stringSum);
    }


    private int moviePrice() {
        int price = -1;
        if (movieId0.isSelected()) {
            price = 100;
        } else if (movieId1.isSelected()) {
            price = 110;
        } else if (movieId2.isSelected()) {
            price = 120;
        } else if (movieId3.isSelected()) {
            price = 130;
        }

        return price;
    }
    private int numberOfTicketsOrdered() {
        int numberOfTickets = -1;
        if (ticketsOrdered1.isSelected()) {
            numberOfTickets = 1;
        } else if (ticketsOrdered2.isSelected()) {
            numberOfTickets = 2;
        } else if (ticketsOrdered3.isSelected()) {
            numberOfTickets = 3;
        } else if (ticketsOrdered4.isSelected()) {
            numberOfTickets = 4;
        } else if (ticketsOrdered5.isSelected()) {
            numberOfTickets = 5;
        } else if (ticketsOrdered6.isSelected()) {
            numberOfTickets = 6;
        } else if (ticketsOrdered7.isSelected()) {
            numberOfTickets = 7;
        } else if (ticketsOrdered8.isSelected()) {
            numberOfTickets = 8;
        }

        return numberOfTickets;
    }


}
