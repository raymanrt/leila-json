package com.github.raymanrt.leila.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class JsonFormatter {

    private final Gson gson;

    public JsonFormatter(String[] args) {

        final GsonBuilder builder = new GsonBuilder();

        final boolean prettyPrint = Arrays.stream(args)
                .filter(arg -> arg.equals("pprint"))
                .findFirst()
                .isPresent();

        if(prettyPrint) {
            builder.setPrettyPrinting();
        }

        gson = builder.create();
    }

    public String format(Document doc) {
        Map<String, Object> map = new HashMap<>();

        for(IndexableField field : doc.getFields()) {
            String[] values = doc.getValues(field.name());
            if(values.length == 1) {
                map.put(field.name(), values[0]);
            } else {
                map.put(field.name(), Arrays.asList(values));
            }
        }

        return gson.toJson(map);

    }
}
