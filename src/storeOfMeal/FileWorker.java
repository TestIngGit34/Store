package storeOfMeal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 17.04.2016.
 */
public class FileWorker {

    public List<Entry> readFile(File file){

        ArrayList<Entry> list = new ArrayList<>();


        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectOut = new ObjectInputStream(fileInputStream);

            while (true){

                try {

                    list.add((Entry)(objectOut.readObject()));

                }catch (ClassNotFoundException h)

                {

                    h.printStackTrace();
                }
                catch (EOFException h) {

                    break;
                }

            }
            objectOut.close();


        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public void writeFile (List<Entry> list,File file){


        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);

            for (Entry entry:list) {

                stream.writeObject(entry);

            }

            stream.close();

        }

            catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            catch (IOException e) {
            e.printStackTrace();
        }

        }

    }


