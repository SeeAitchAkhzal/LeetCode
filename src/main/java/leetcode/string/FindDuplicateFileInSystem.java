package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Runtime: 58 ms, faster than 55.86% of Java online submissions for Find Duplicate File in System.
 */

public class FindDuplicateFileInSystem {

    HashMap<String, Set<String>> contentToFile = new HashMap();

    public List<List<String>> findDuplicate(String[] paths) {

        for (String info : paths) {
            String[] listing = info.split(" ");
            String path = listing[0];

            for (int i = 1; i < listing.length; i++) {
                handleFile(createFileName(path, listing[i]), listing[i]);
            }
        }

        return prepareResult();
    }

    String createFileName(String path, String fileWithContent) {
        return path + "/" +
               fileWithContent.substring(0, fileWithContent.indexOf('('));
    }

    List<List<String>> prepareResult() {
        List<List<String>> result = new ArrayList();

        for (Map.Entry<String, Set<String>> entry : contentToFile.entrySet()) {

            if (entry.getValue().size() > 1) {
                result.add(new ArrayList(entry.getValue()));
            }
        }

        return result;
    }

    String extractContent(String file) {
        return file.substring(file.indexOf('(') + 1, file.indexOf(')'));
    }

    void handleFile(String fileName, String file) {
        String content = extractContent(file);

        if (contentToFile.containsKey(content)) {
            contentToFile.get(content).add(fileName);
        } else {
            Set<String> set = new HashSet();
            set.add(fileName);
            contentToFile.put(content, set);
        }
    }
}
