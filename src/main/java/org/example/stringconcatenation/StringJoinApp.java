package org.example.stringconcatenation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringJoinApp {
    /**
     * Code examples that produce strings wrapped by quotes and braces
     * 1. ('id_AAA_1000','id_AAA_1001','id_AAA_1002')
     * 2. ('id_AAA_1000','name_AAA_1000'),('id_AAA_1001','name_AAA_1001'),('id_AAA_1002','name_AAA_1002')
     * 3. 'name_AAA_1000','name_AAA_1001','name_AAA_1002'
     * 4. '12','34','56','47','56','34','56','78','90','12','12','34','45'
     */
    public static void main(String[] args) {
        StringJoinUtil util = new StringJoinUtil();
        List<PairModel> models = generateDummyModels();
        String result = util.wrapAndJoinSingleElements(models);
        System.out.println(result);

        result = util.wrapAndJoinPairs(models);
        System.out.println(result);

        List<String> names = models.stream()
                .map(PairModel::getName)
                .collect(Collectors.toList());

        result = util.streamJoiningExample(names);
        System.out.println(result);

        util.wrapUpStringValuesByQuoteUsingReplaceAll();
        util.stringJoinExample();
    }

    private static List<PairModel> generateDummyModels() {
        return IntStream.range(1000, 1003)
                .boxed()
                .map(id -> new PairModel("id_AAA_" + id, "name_AAA_" + id))
                .collect(Collectors.toList());
    }

}