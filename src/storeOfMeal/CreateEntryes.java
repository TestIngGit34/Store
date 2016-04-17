package storeOfMeal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 17.04.2016.
 */
public final class CreateEntryes {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public List<Entry> createEntryes() {

        ArrayList<Entry> list = new ArrayList<>();

        while (true){

            System.out.println("Для создания записи введите данные в таком порядке через Enter :\nТип, Имя, Дата изготовления," +
                    "Срок годности мес., Количество на складе, Цена, Страна изготовления");

            try {

                list.add(new Entry(
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine(),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        Double.parseDouble(reader.readLine()),
                        reader.readLine())
                );

            }
            catch (IOException d){

                d.printStackTrace();
            }
            System.out.println("Ввести еще одну запись? д/н?");

            try {
                if (!"д".equals(reader.readLine()))break;

            } catch (IOException e) {

                e.printStackTrace();
            }

        }

        return list;
    }
}
