package Interfaces;

import Exceptions.EatItemException;
import items.Crock;
import items.Food;
import items.Watch;

public interface IHungry{

    void toHungry(Watch watch) throws EatItemException;
}
