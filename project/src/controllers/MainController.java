package controllers;

import models.MainModel;
import views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The program's main controller. Responsible for the communication between views and models,
 * responding to user input.
 * @author Emma Pesjak
 */
public class MainController {

    private final MainModel mainModel = new MainModel();
    private final MainView mainView = new MainView(new ButtonListener());

    public MainController() {

    }

    /**
     * Inner class responsible for listening to the solve button.
     */
    class ButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (mainModel.calculate(mainView.getFileName())) {
                    mainView.displayResults();

                } else {
                    mainView.displayErrorMsg("Did not work."); // Annat felmeddeleande här?
                }
            } catch (Exception exception) { // vilken sorts exception?
                System.out.println(exception);
                mainView.displayErrorMsg("Please enter a valid file name.");
            }
        }
    }

}
