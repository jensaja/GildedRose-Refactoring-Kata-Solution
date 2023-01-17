package com.gildedrose.submodel;

import com.gildedrose.Item;

public abstract class UpdatableItem extends Item {

    public UpdatableItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public abstract void update();

    protected void decreaseSellIn() {
        sellIn--;
    }

    public void copyUpdatedValuesToItem(Item item) {
        item.sellIn = this.sellIn;
        item.quality = this.quality;
    }

}
