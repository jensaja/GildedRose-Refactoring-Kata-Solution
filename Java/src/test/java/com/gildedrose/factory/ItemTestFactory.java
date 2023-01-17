package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.submodel.AgedItem;
import com.gildedrose.submodel.BackstagePassItem;

import java.util.Random;

public class ItemTestFactory {

    private static final Random random = new Random();

    public static final String ITEM_TEST_NAME = "Foo item";
    public static final int ITEM_TEST_SELLIN = 15;
    public static final int ITEM_TEST_QUALITY = 30;

    /**
     * Generates an Item with a random name, a random sellIn value (from 4 to 31) and a random quality (from 5 to 50)
     *
     * @return an Item with random values
     */
    public static Item createRandomItem() {
        String randomName = "Random item nr. " + random.nextInt(1, Integer.MAX_VALUE);
        int randomSellIn = random.nextInt(4, 32);
        int randomQuality = random.nextInt(5, 51);
        return new Item(randomName, randomSellIn, randomQuality);
    }

    /**
     * Generates an Item with ITEM_TEST_NAME as name, a random sellIn value (from 4 to 31) and a random quality (from 5 to 50)
     *
     * @return an Item with ITEM_TEST_NAME and random sellIn and quality values
     */
    public static Item createItemWithTestName() {
        Item item = createRandomItem();
        item.name = ITEM_TEST_NAME;
        return item;
    }

    /**
     * Generates an Item with ITEM_TEST_NAME as name, ITEM_TEST_SELLIN as sellIn value and ITEM_TEST_QUALITY as quality value
     *
     * @return an Item with constant values for each field
     */
    public static Item createTestItem() {
        return new Item(ITEM_TEST_NAME, ITEM_TEST_SELLIN, ITEM_TEST_QUALITY);
    }

    /**
     * Generates an Item with "Aged Brie" as name, ITEM_TEST_SELLIN as sellIn value and ITEM_TEST_QUALITY as quality value
     *
     * @return an Item named "Aged Brie" with constant values for each field
     */
    public static Item createTestAgedBrie() {
        return new Item(AgedItem.KEY, ITEM_TEST_SELLIN, ITEM_TEST_QUALITY);
    }

    /**
     * Generates an Item with "Backstage passes to a TAFKAL80ETC concert" as name, daysToConcert as sellIn value and ITEM_TEST_QUALITY as quality value
     *
     * @param daysToConcert the amount of days until the concert
     * @return an Item named "Backstage passes to a TAFKAL80ETC concert" with daysToConcert as sellIn value and a constant value for quality
     */
    public static Item createTestBackstagePass(int daysToConcert) {
        return new Item(BackstagePassItem.KEY, daysToConcert, ITEM_TEST_QUALITY);
    }

    /**
     * Generates an Item with "Conjured cake" as name, ITEM_TEST_SELLIN as sellIn value and ITEM_TEST_QUALITY as quality value
     *
     * @return an Item named "Conjured cake" with constant values for each field
     */
    public static Item createTestConjuredItem() {
        return new Item("Conjured cake", ITEM_TEST_SELLIN, ITEM_TEST_QUALITY);
    }

}
