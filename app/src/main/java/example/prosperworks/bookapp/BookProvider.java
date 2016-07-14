package example.prosperworks.bookapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by greg on 2/11/16.
 */
public class BookProvider {


    public static List<List<String>> getBooks() {
        List<List<String>> list = new ArrayList<>(20);

        ArrayList<String> authorData = new ArrayList<>(3);
        authorData.add("J.R.R");
        authorData.add("Tolkien");
        authorData.add("81");

        list.add(new ArrayList<String>(Arrays.asList("The Fellowship of the Ring", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Two Towers", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Return of the King", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Hobbit", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("Beowulf: The Monsters and the Critics", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Silmarillion", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("Unfinished Tales and The History of Middle-earth", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Children of Húrin", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Legend of Sigurd and Gudrún", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList(null, authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("The Fall of Arthur", authorData.get(0), authorData.get(1), "-1")));
        list.add(new ArrayList<String>(Arrays.asList("Mr. Bliss", authorData.get(0), authorData.get(1), authorData.get(2))));
        list.add(new ArrayList<String>(Arrays.asList("Mr. Bliss: The sequel", null, null, authorData.get(2))));
        list.add(null);
        list.add(new ArrayList<String>(Arrays.asList("Mr. Bliss: The Trilogy", authorData.get(0), authorData.get(1), authorData.get(2))));

        return list;
    }
}
