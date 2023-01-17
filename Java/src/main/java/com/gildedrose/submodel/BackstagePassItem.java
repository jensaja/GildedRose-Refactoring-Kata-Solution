package com.gildedrose.submodel;

import com.gildedrose.Item;

public class BackstagePassItem extends IncreasingQualityItem {

    public BackstagePassItem(Item item) {
        super(item);
    }

    /**
     * Quality increases as the item's SellIn value approaches.
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     */
    @Override
    public void update() {
        if(sellIn <= 0) {
            quality = 0;
        } else {
            increaseQuality();
            if (sellIn < 11) {
                increaseQuality();
            }
            if (sellIn < 6) {
                increaseQuality();
            }
        }
        decreaseSellIn();
    }
}
