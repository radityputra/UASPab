package com.if3a.Quotable.model;

import java.util.ArrayList;

public class rootAuthors {
    public int count;
    public int totalCount;
    public int page;
    public int totalPages;
    public int lastItemIndex;
    public ArrayList<results> results;

    public ArrayList<results> getResults() {
        return results;
    }
}
