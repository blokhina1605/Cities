package com.epam.blokhina.game;

/**
 * Created by Yevheniia_Blokhina on 5/14/2015.
 */
public class City {
    private String name;

    public City(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public char getLastLetter() {
        int i = 1;
        char last = name.charAt(name.length() - i);

        while (last == 'ь' || last == 'ъ' || last == 'ы') {
            i++;
            last = name.charAt(name.length() - i);
        }
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return !(getName() != null ? !getName().equals(city.getName()) : city.getName() != null);

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public char getFirstLetter() {
        return name.charAt(0);
    }

}
