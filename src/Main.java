import com.duskode.Treet;
import com.duskode.Treets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Treet[] treets = Treets.load();

        // Initialize hashTagCounts
        Map<String, Integer> hashTagCounts = new HashMap<String, Integer>();

        // Loop over treets
        for (Treet treet : treets) {
            // Loop over hashtags
            for (String hashTag : treet.getHashTags() ) {
                // Get hashTag's value
                Integer count = hashTagCounts.get(hashTag);
                // If it hasn't been set yet, set it to 0 to start
                if (count == null) {
                    count = 0;
                }
                // increase the hashTag's value by 1
                count++;
                // update hashTagCounts
                hashTagCounts.put(hashTag, count);
            }
        }


        Map<String, List<Treet>> treetsByAuthor = new HashMap<String, List<Treet>>();

        for (Treet treet : treets) {
            List<Treet> authoredTreets = treetsByAuthor.get(treet.getAuthor());
            if (authoredTreets == null) {
                authoredTreets = new ArrayList<Treet>();
                treetsByAuthor.put(treet.getAuthor(), authoredTreets);
            }
            authoredTreets.add(treet);
        }

        System.out.printf("Treets by author: %s %n ", treetsByAuthor);


    }
}
