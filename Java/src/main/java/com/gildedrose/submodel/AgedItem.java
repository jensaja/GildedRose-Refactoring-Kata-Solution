package com.gildedrose.submodel;

import com.gildedrose.Item;

public class AgedItem extends IncreasingQualityItem {

    public static final String KEY = "Aged Brie";

    public AgedItem(Item item) {
        super(item);
    }

    /**
     * Increases in Quality the older the item gets.
     * The Quality of an item is never more than 50.
     */
    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if (sellIn < 0) {
            increaseQuality();
        }
    }
}
