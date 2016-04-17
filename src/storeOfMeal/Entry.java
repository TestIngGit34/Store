package storeOfMeal;

import java.io.Serializable;

/**
 * Created on 17.04.2016.
 */
public class Entry implements Serializable {

    private String type;
    private String name;
    private String date;
    private int expireDateMonths;
    private int amount;
    private double cost;
    private String madeIn;


    public Entry(String type, String name, String date, int expireDateMonths, int amount, double cost,String madeIn) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.expireDateMonths = expireDateMonths;
        this.amount = amount;
        this.cost = cost;
        this.madeIn = madeIn;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getExpireDateMonths() {
        return expireDateMonths;
    }

    public int getAmount() {
        return amount;
    }

    public double getCost() {
        return cost;
    }

    public String getMadeIn() {
        return madeIn;
    }

    @Override
    public String toString() {
        return
                "Тип: " + type +" / "+
                "Наименование: " + name +" / "+
                "Дата изготовления: " + date +" / "+
                "Срок годности мес.: " + expireDateMonths +" / "+
                "Количество: " + amount +" / "+
                "Цена: " + cost +" / "+
                "Страна изготовитель: " + madeIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        return madeIn != null ? madeIn.equals(entry.madeIn) : entry.madeIn == null;

    }

    @Override
    public int hashCode() {
        return madeIn != null ? madeIn.hashCode() : 0;
    }
}
