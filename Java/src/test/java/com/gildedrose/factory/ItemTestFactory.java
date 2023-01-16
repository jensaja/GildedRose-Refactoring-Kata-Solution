package com.gildedrose.factory;

import com.gildedrose.Item;

import java.util.Random;

public class ItemTestFactory {

    private static final Random random = new Random();

    public static final String ITEM_TEST_NAME = "Foo item";

    /**
     * Generates an Item with a random name, a random sellIn value (from 1 to 31) and a random quality (from 1 to 50)
     *
     * @return an Item with random values
     */
    private static Item createRandomItem() {
        String randomName = "Random item nr. " + random.nextInt(1, Integer.MAX_VALUE);
        int randomSellIn = random.nextInt(1, 32);
        int randomQuality = random.nextInt(1, 51);
        return new Item(randomName, randomSellIn, randomQuality);
    }

    /**
     * Generates an Item with ITEM_TEST_NAME as name, a random sellIn value (from 1 to 31) and a random quality (from 1 to 50)
     *
     * @return an Item with ITEM_TEST_NAME and random sellIn and quality values
     */
    public static Item createItemWithTestName() {
        Item item = createRandomItem();
        item.name = ITEM_TEST_NAME;
        return item;
    }

}
