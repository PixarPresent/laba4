package Exceptions;

import entities.Entity;
import items.Item;

public class EatItemException extends Exception{
    Entity entity;
    Item item;
    public EatItemException(Entity entity, Item item) {
        super("\nВНИМАНИЕ ПЕРСОНАЖ: " + entity.getName() + "\nСЪЕЛ ПРЕДМЕТ: " + item.getName() + "\n");
        this.item = item;
        this.entity = entity;
    }
}
