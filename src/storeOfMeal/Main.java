package storeOfMeal;

import java.io.IOException;

/**
 * Created on 17.04.2016.
 */
public class Main   {

    public static void main(String[] args) {

        MainWorker mainWorker = MainWorker.getInstance();

        try {
            mainWorker.printInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
