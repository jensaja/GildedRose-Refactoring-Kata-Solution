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
        assertEquals(ItemTestFactory.ITEM_TEST_SELLIN - 1, testItem.sellIn);
    }

    @Test
    public void whenUpdateQualityThenQualityValueGetsDecreased() {
        Item testItem = ItemTestFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemTestFactory.ITEM_TEST_QUALITY - 1, testItem.quality);
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

    @Test
    public void whenUpdateQualityOfAgedBrieThenQualityIncreases() {
        Item testItem = ItemTestFactory.createTestAgedBrie();
        runUpdateQualityForSingleItem(testItem);
        assertTrue(testItem.quality > ItemTestFactory.ITEM_TEST_QUALITY);
    }

    @Test
    public void whenUpdateQualityOfAgedBrieThenQualityGetsNoHigherThan50() {
        Item testItem = ItemTestFactory.createTestAgedBrie();
        testItem.quality = 49;

        // first update: quality was 49 --> gets updated to 50
        runUpdateQualityForSingleItem(testItem);
        assertEquals(50, testItem.quality);

        // second update: quality was 50 --> quality doesn't get any higher
        runUpdateQualityForSingleItem(testItem);
        assertEquals(50, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfSulfurasThenNeitherSellInNorQualityGetsChanged() {
        Item testItem = ItemTestFactory.createTestItem();
        testItem.name = "Sulfuras, Hand of Ragnaros";

        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemTestFactory.ITEM_TEST_SELLIN, testItem.sellIn);
        assertEquals(ItemTestFactory.ITEM_TEST_QUALITY, testItem.quality);
    }

    private void runUpdateQualityAndAssertThatQualityHasIncreased(Item testItem, int qualityIncrease) {
        int qualityBeforeUpdate = testItem.quality;
        runUpdateQualityForSingleItem(testItem);
        assertEquals(qualityBeforeUpdate + qualityIncrease, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityChangesNormallyUpTo11DaysToTheConcert() {
        Item testItem = ItemTestFactory.createTestBackstagePass(11);
        runUpdateQualityAndAssertThatQualityHasIncreased(testItem, 1);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityIncreasesByTwoWhen10DaysOrLessToTheConcert() {
        Item testItem = ItemTestFactory.createTestBackstagePass(9);
        runUpdateQualityAndAssertThatQualityHasIncreased(testItem, 2);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityIncreasesByThreeWhen5DaysOrLessToTheConcert() {
        Item testItem = ItemTestFactory.createTestBackstagePass(5);
        runUpdateQualityAndAssertThatQualityHasIncreased(testItem, 3);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityDropsToZeroAfterConcert() {
        Item testItem = ItemTestFactory.createTestBackstagePass(0);

        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfConjuredItemThenQualityDecreasesTwiceAsFast() {
        Item testItem = ItemTestFactory.createTestConjuredItem();

        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemTestFactory.ITEM_TEST_QUALITY - 2, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfConjuredItemAndSellByDateHasPassedThenQualityDecreasesFourTimesAsFast() {
        Item testItem = ItemTestFactory.createTestConjuredItem();
        testItem.sellIn = 0;

        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemTestFactory.ITEM_TEST_QUALITY - 4, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfConjuredItemThenQualityGetsNeverNegative() {
        Item testItem = ItemTestFactory.createTestConjuredItem();
        testItem.quality = 1;

        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);
    }
}
