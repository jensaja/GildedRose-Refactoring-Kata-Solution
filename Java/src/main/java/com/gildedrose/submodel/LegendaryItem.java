package com.gildedrose.submodel;

import com.gildedrose.Item;

public class LegendaryItem extends UpdatableItem {

    public static final String KEY = "Sulfuras, Hand of Ragnaros";

    public LegendaryItem(Item item) {
        super(item);
    }

    /**
     * Legendary item never has to be sold or decreases in Quality
     */
    @Override
    public void update() {
        // nothing needs to change
    }
}
