package com.gildedrose;

import com.gildedrose.submodel.*;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .forEach(item -> {
                UpdatableItem updatableItem = switch (item.name) {
                    case "Aged Brie" -> new AgedItem(item);
                    case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassItem(item);
                    case "Sulfuras, Hand of Ragnaros" -> new LegendaryItem(item);
                    default -> new ClassicItem(item);
                };
                updatableItem.updateOriginalItem();
            });
    }
}
