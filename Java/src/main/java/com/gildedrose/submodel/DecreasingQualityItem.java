package com.gildedrose.submodel;

import com.gildedrose.Item;

public abstract class DecreasingQualityItem extends UpdatableItem {

    public DecreasingQualityItem(Item item) {
        super(item);
    }

    protected void decreaseQuality() {
        if (quality > 0) {
            quality--;
        }
    }
}
