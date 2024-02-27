package Interfaces;

import entities.FairyPerson;
import entities.UsualPerson;
import items.Item;

public interface ISee {
    void toWatch(Item item, String description);

    void toWatch(UsualPerson person, String description);

    void toWatch(FairyPerson person, String description);
}
