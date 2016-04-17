package storeOfMeal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created on 17.04.2016.
 */
public class MainWorker  {

    private final String ERROR_MSG = "Сначала нужно открыть файл!";

    public static MainWorker getInstance() {

        if (instance ==null){

            instance =new MainWorker();
        }
        return instance;
    }

    private MainWorker() {
    }

    private static MainWorker instance;

    public List<Entry> getListOfEntries() {
        return listOfEntries;
    }

    public void setListOfEntries(List<Entry> listOfEntries) {
        this.listOfEntries = listOfEntries;
    }

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private List<Entry> listOfEntries;

    public boolean isListPresent() {
        return listPresent;
    }

    public void setListPresent(boolean listPresent) {
        this.listPresent = listPresent;
    }

    private boolean listPresent;



    public void printInterface () throws IOException{

        System.out.println("\n--- Информационно-поисковая система ---\n\n1.Создать/открыть файл\n2.Вывести все записи\n3." +
                "Вывести все товары с ценой не превыщающей заданной\n4.Вывести товары определенного вида, срок годности " +
                "менее 2-х лет\n5.Вывести страну-производителя товара, которого больше всего на складе\n" +
                "6.Выход\n\nДля продолжения введите номер пункта меню :\n");


        if (instance.getListOfEntries()==null) instance.setListPresent(false);

        switch (Integer.parseInt(bufferedReader.readLine())){


            case 1:

                FileWorker fileWorker = new FileWorker();
                System.out.println("1.Создать файл.\n2.Открыть файл.");

                if(1==Integer.parseInt(bufferedReader.readLine())){
                    System.out.println("Введите полный путь к файлу вместе с расширением.\nПример: С:\\myFile.db\n\nЕсли " +
                            "файл существует, то будет перезаписан!");

                    File file = new File(bufferedReader.readLine());
                    fileWorker.writeFile(new CreateEntryes().createEntryes(),file);
                    instance.printInterface();

                }

                 else {

                System.out.println("Введите полный путь к файлу вместе с расширением.\nПример: С:\\myFile.db");

                    File file = new File(bufferedReader.readLine());

                   instance.setListOfEntries( fileWorker.readFile(file));
                    System.out.println("\nФайл открыт, количество записей: " + instance.getListOfEntries().size());
                    instance.setListPresent(true);
                    instance.printInterface();

            }
                break;

            case 2:

                if (instance.isListPresent()){

                    EntriesToConsole.allToConsole(instance.getListOfEntries());
                    instance.printInterface();}

                else {

                    System.out.println(ERROR_MSG);
                    instance.printInterface();}

                break;

            case 3:

                if (listPresent){

                    System.out.println("Введите цену: ");
                    EntriesToConsole.goodsUnderCost(instance.getListOfEntries(),Double.parseDouble(bufferedReader.readLine()));
                    instance.printInterface();

                   }

                else{

                    System.out.println(ERROR_MSG);
                    instance.printInterface();
                }

                break;

            case 4:

                if (listPresent){

                    System.out.println("Введите вид товара который вы хотите вывести: ");
                    EntriesToConsole.someTypeUnder2years(instance.getListOfEntries(), bufferedReader.readLine());
                    instance.printInterface();}

                else{

                    System.out.println(ERROR_MSG);
                    instance.printInterface();
                }
                break;

            case 5:

                if (listPresent){

                    System.out.println(EntriesToConsole.showCountry(instance.getListOfEntries()));
                    instance.printInterface();
                }

                else{
                    System.out.println(ERROR_MSG);
                    instance.printInterface();}
                break;

            case 6:

                System.out.println("Завершение работы...");
                System.exit(0);
                break;

        }

    }


}
