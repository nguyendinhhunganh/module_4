package codegym.service.impl;

import codegym.service.LibraryService;

import java.util.LinkedHashMap;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {
    public static Map<String,String> library = new LinkedHashMap();
    static {
        library.put("Hello", "Xin chao");
        library.put("Bye", "Tam biet");
        library.put("Boy", "Con trai");
        library.put("Girl", "Con gai");
        library.put("Handsome", "Dep trai");
    }

    @Override
    public String find(String english) {
        for (Map.Entry<String, String> library: library.entrySet()){
            if (library.getKey().equals(english)){
                return library.getValue();
            }
        }
        return null;
    }
}
