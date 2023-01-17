package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> increaseQuality(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> {
                    increaseQuality(item);
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }
                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
                default -> {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie" -> increaseQuality(item);
                    case "Backstage passes to a TAFKAL80ETC concert" -> item.quality = 0;
                    default -> {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality(item);
                        }
                    }
                }
            }
        }
    }
}
