package com.gildedrose;

import com.gildedrose.factory.ItemTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    private void runUpdateQualityForSingleItem(Item testItem){
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
    }

    @Test
    public void whenUpdateQualityThenItemsNameIsNotChanged() {
        Item testItem = ItemTestFactory.createItemWithTestName();
        assertEquals(ItemTestFactory.ITEM_TEST_NAME, testItem.name);
    }

    @Test
    public void whenUpdateQualityThenSellInValueGetsDecreased() {
        Item testItem = ItemTestFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertTrue(testItem.sellIn < ItemTestFactory.ITEM_TEST_SELLIN);
    }

    @Test
    public void whenUpdateQualityThenQualityValueGetsDecreased() {
        Item testItem = ItemTestFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertTrue(testItem.quality < ItemTestFactory.ITEM_TEST_QUALITY);
    }
}
