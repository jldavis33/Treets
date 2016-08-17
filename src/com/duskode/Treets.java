package com.duskode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Created by joshdavis on 8/12/16.
 */
public class Treets {

    public static void save(Treet[] treets) {
        // Create file stream
        try {
            // create new file
            FileOutputStream fos = new FileOutputStream("treets.ser");

            // pass stream into object-output stream
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // ..use its writeObject method to serialize "treets"
            oos.writeObject(treets);

            // required to close streams
            oos.close(); fos.close();
        } catch (IOException ioe) {
            System.out.println("Problem saving Treets");

            // Show print stack trace to help locate issues
            ioe.printStackTrace();
        }
    }

    public static Treet[] load() {
        Treet[] treets = new Treet[0];

        try {
            // open up stream to specified file
            FileInputStream fis = new FileInputStream("treets.ser");
            // pass that stream into an ObjectInputStream for reading
            ObjectInputStream ois = new ObjectInputStream(fis);
            // set the read input to "treets"
            treets = (Treet[]) ois.readObject();
            // close the streams
            ois.close(); fis.close();
        } catch (IOException ioe) {
            System.out.println("Error reading file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading Treets");
            cnfe.printStackTrace();
        }
        return treets;
    }
}


//    // create treats
//    Treet firstTreet = new Treet(
//            "joshdavis",
//            "Hey this is my first message @jmvadvincula",
//            new Date(1421849732000L)
//    );
//    Treet secondTreet = new Treet(
//            "jmvadvincula",
//            "Hey @joshdavis. This is a great exercise. #winning",
//            new Date(1421849732000L)
//    );