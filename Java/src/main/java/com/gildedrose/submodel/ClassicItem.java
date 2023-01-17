package com.gildedrose.submodel;

import com.gildedrose.Item;

public class ClassicItem extends DecreasingQualityItem {

    public ClassicItem(Item item) {
        super(item);
    }

    /**
     * Decreases sellIn by 1 (min. 0) and decreases quality by 1 (min. 0).
     * Once the sell by date has passed, Quality degrades twice as fast.
     */
    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (sellIn < 0) {
            decreaseQuality();
        }
    }

}
