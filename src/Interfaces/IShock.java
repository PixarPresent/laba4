package Interfaces;

import Exceptions.WrongSuperAbilityException;

public interface IShock {
    void toCountAbility(boolean shocked) throws WrongSuperAbilityException;
}
