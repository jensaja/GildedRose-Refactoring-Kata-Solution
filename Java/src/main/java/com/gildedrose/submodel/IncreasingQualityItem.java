package com.gildedrose.submodel;

import com.gildedrose.Item;

public abstract class IncreasingQualityItem extends UpdatableItem {

    public IncreasingQualityItem(Item item) {
        super(item);
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }
}
