# A possible solution to the Gilded Rose Refactoring Kata

This is a solution in Java to the famous [Gilded Rose Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata).
The original requirements can be found in GildedRoseRequirements.txt.

## Solution

My solution was committed in 4 branches:
* **unit-tests**: add unit tests without changing the original business logic code
* **refactor**: perform the actual refactor of the business logic code
* **feature-conjured**: add the new feature regarding conjured items
* **documentation**: add some documentation

The main idea behind my refactor is to have some new classes deriving from `Item` (as we are not allowed to change the existing `Item` class), starting with the abstract `UpdatableItem` class.
Its final subclasses implement the `update` method, which performs the update logic on the `UpdatableItem`'s quality and sellIn values depending on the item type.

![class diagram](GildedRoseClassUML.png?raw=true "class diagram")

The `GildedRose::updateQuality` method simply loops through all `items`, creates an `UpdatableItem` object (actual class depends on detected item type) and calls its `updateOriginalItem` method.