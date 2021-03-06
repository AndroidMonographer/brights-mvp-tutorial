package com.examples.bright.tutorial.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bright on 17/07/2017.
 */

public class CharactersEntity {

    @SerializedName("available")
    private int available;

    @SerializedName("collectionURI")
    private String collectionURI;

    @SerializedName("items")
    private List<Object> items = null;

    @SerializedName("returned")
    private int returned;
    /**
     *
     * @param items
     * @param collectionURI
     * @param available
     * @param returned
     */
    public CharactersEntity(int available, String collectionURI, List<Object> items, int returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public int getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<Object> getItems() {
        return items;
    }

    public int getReturned() {
        return returned;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "available=" + available +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                ", returned=" + returned +
                '}';
    }
}
