package Interfaces;

import Exceptions.EatItemException;
import items.Crock;
import items.Food;

public interface IEat {
    void toEat(Food food);

    void toEat(Crock crock) throws EatItemException;

}
