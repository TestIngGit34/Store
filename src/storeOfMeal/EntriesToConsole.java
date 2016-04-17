package storeOfMeal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 17.04.2016.
 */
public class EntriesToConsole {

    private static String answerCountry ="empty";
    private static  int goodsAmount =0;

    public static void allToConsole(List<Entry> list){

        for (Entry entry:list) {
            System.out.println(entry);
        }
    }

    public static void goodsUnderCost(List<Entry> list,double price){


        for (Entry entry:list) {

            if (entry.getCost()<price)
                System.out.println(entry);

        }

    }

    public static void someTypeUnder2years(List<Entry> list , String type){


        for (Entry entry:list){

            if (type.equals(entry.getType()) & entry.getExpireDateMonths()<24){

                System.out.println(entry);
            }

        }

    }

    public static String showCountry(List<Entry> list){

        HashMap <String,Integer> map = new HashMap<>();

        for (Entry entry:list) {

            if (map.get(entry.getMadeIn())!=null)

            map.put(entry.getMadeIn(),entry.getAmount()+map.get(entry.getMadeIn()));

            else

            map.put(entry.getMadeIn(),entry.getAmount());
        }




        for (Map.Entry<String,Integer> entry : map.entrySet()) {


            if (goodsAmount < entry.getValue()){

                goodsAmount = entry.getValue();
                answerCountry = entry.getKey();

            }


        }

        return answerCountry;
        }

    }




