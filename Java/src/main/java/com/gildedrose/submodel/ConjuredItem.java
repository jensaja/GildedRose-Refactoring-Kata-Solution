package com.gildedrose.submodel;

import com.gildedrose.Item;

public class ConjuredItem extends DecreasingQualityItem {

    public static final String KEY_PREFIX = "Conjured ";

    public ConjuredItem(Item item) {
        super(item);
    }

    /**
     * Degrade in Quality twice as fast as normal items
     */
    @Override
    protected void update() {
        decreaseQuality(2);
        decreaseSellIn();
        if (sellIn < 0) {
            decreaseQuality(2);
        }
    }
}
