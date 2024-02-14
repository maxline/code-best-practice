package org.example.stringconcatenation;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * https://www.baeldung.com/java-strings-concatenation
 * https://www.baeldung.com/java-string-concatenation-methods
 * 
 * Speed comparison of string joining practices:
 * <a href="https://medium.com/javarevisited/5-effective-string-practices-you-should-know-e9a75811b123">...</a>
 * What can we conclude? String.concat is the best option for two strings join. 
 * This way we don’t create additional StringBuilder or StringBuffer. 
 * Even thoughString.concat isn't the fastest, it beats other options in throughput.
 */
public class StringJoinUtil {
    /**
     * joining example with next format:
     * ('id_AAA_1000','id_AAA_1001','id_AAA_1002')
     */
    public String wrapAndJoinSingleElements(List<PairModel> models) {
        return models.stream()
                .map(PairModel::getId)
                .collect(joining("','", "('", "')"));
    }

    /**
     * joining example with next format:
     * ('id_AAA_1000','name_AAA_1000'),('id_AAA_1001','name_AAA_1001'),('id_AAA_1002','name_AAA_1002')
     */
    public String wrapAndJoinPairs(List<PairModel> models) {
        return models.stream()
                .map(model -> model.getId().concat("','").concat(model.getName()))
                .collect(joining("'),('", "('", "')"));
    }

    public void stringJoinExample() {
        String[] strings = {"I'm", "running", "out", "of", "pangrams!"};
        String myString = String.join("--", strings);
        System.out.println(myString);
    }

    /**
     * joining example with next format:
     * 'name_AAA_1000','name_AAA_1001','name_AAA_1002'
     * https://stackoverflow.com/questions/17400583/how-to-add-or-insert-single-quotes-for-every-string-in-a-list-in-which-strin
     */
    public String streamJoiningExample(List<String> list) {
        return list.stream()
                .collect(Collectors.joining("','", "'", "'"));
    }

    /**
     * Adding a Single quote in String based on the delimiter
     * https://stackoverflow.com/questions/32220339/java-adding-a-single-quote-in-string-based-on-the-delimeter
     */
    public void wrapUpStringValuesByQuoteUsingReplaceAll() {
        String values = "12,34,56,47,56,34,56,78,90,12,12,34,45";
        String output = values.replaceAll("(\\w+)", "'$1'");
        System.out.println(output);
    }

}
