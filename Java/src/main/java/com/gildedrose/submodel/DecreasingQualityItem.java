package com.gildedrose.submodel;

import com.gildedrose.Item;

public abstract class DecreasingQualityItem extends UpdatableItem {

    public DecreasingQualityItem(Item item) {
        super(item);
    }

    protected void decreaseQuality() {
        decreaseQuality(1);
    }

    protected void decreaseQuality(int amount){
        quality = Math.max(0, quality - amount);
    }
}
