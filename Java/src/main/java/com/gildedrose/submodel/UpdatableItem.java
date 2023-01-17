package com.gildedrose.submodel;

import com.gildedrose.Item;

public abstract class UpdatableItem extends Item {

    private final Item originalItem;

    public UpdatableItem(Item item) {
        super(item.name, item.sellIn, item.quality);
        this.originalItem = item;
    }

    protected abstract void update();

    protected void decreaseSellIn() {
        sellIn--;
    }

    public void updateOriginalItem() {
        update();
        originalItem.sellIn = this.sellIn;
        originalItem.quality = this.quality;
    }

}
