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

    @Test
    public void whenUpdateQualityAndSellByDateHasPassedThenQualityDecreasesTwiceAsFast() {
        Item testItem = ItemTestFactory.createRandomItem();
        testItem.sellIn = 1;
        int originalQuality = testItem.quality;

        // first update: sell in 1 day --> normal behaviour
        runUpdateQualityForSingleItem(testItem);
        int qualityAfterFirstUpdate = testItem.quality;
        int normalQualityDiff = originalQuality - qualityAfterFirstUpdate;

        // second update: sell in 0 days --> sell by date has passed: quality decreases twice as fast
        runUpdateQualityForSingleItem(testItem);
        int expiredQualityDiff = qualityAfterFirstUpdate - testItem.quality;
        assertEquals(2 * normalQualityDiff, expiredQualityDiff);
    }

    @Test
    public void whenUpdateQualityThenQualityGetsNeverNegative() {
        Item testItem = ItemTestFactory.createRandomItem();
        testItem.quality = 0;

        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);

        // also remains 0 when sell by date has passed
        testItem.sellIn = 0;
        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);
    }

}
