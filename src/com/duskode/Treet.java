package com.duskode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Treet implements Comparable<Treet>, Serializable {
    private static final long serialVersionUID = -4055525215893062489L;
    private String mAuthor;
    private String mDescription;
    private Date mCreationDate;

    public Treet(String author, String description, Date creationDate) {
        mAuthor = author;
        mDescription = description;
        mCreationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format("Treet: \"%s\" - @%s on %s",
                             mDescription, mAuthor, mCreationDate);
    }

    @Override
    public int compareTo(Treet other) {
        // if this is equal to "other"
        if (equals(other)) {
            return 0;
        }
        // compare the dates of the Treets
        int dateComparison = mCreationDate.compareTo(other.mCreationDate);
        // if the dates are exactly the same...
        if (dateComparison == 0) {
            // compare the descriptions, return
            return mDescription.compareTo(other.mDescription);
        }
        // return the date comparison
        return dateComparison;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    public List<String> getWords() {
        String[] words = mDescription.toLowerCase().split("[^\\w#@']+");
        return Arrays.asList(words);
    }

    private List<String> getWordsPrefixedWith(String prefix) {
        List<String> results = new ArrayList<String>();

        for (String word : getWords()) {
            if (word.startsWith(prefix)) {
                results.add(word);
            }
        }
        return results;
    }


    public List<String> getMentions() {
        return getWordsPrefixedWith("#");
    }

    public List<String> getHashTags() {
        return getWordsPrefixedWith("@");
    }

}