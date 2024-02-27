package entities;

import Exceptions.EatItemException;
import Exceptions.WrongSuperAbilityException;
import items.Crock;
import items.Watch;


import java.util.ArrayList;

public class  FairyPerson extends Entity {
    private final ArrayList<String> superAbility = new ArrayList<String>();

    public FairyPerson(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    public void useSuperAbility(int number) {
        if (this.isMale())
            System.out.println(this.getName() + " начал " + this.getSuperAbility(number));
        else System.out.println(this.getName() + " начала " + this.getSuperAbility(number));
    }

    @Override
    public void toEat(Crock crock) throws EatItemException {
        if (this.isMale())
            System.out.println(this.getName() + " съел " + crock.getName());
        else System.out.println(this.getName() + " съела " + crock.getName());
        throw new EatItemException(this, crock);
    }




    public String getSuperAbility(int number) {
        return this.superAbility.get(number);
    }

    public void addSuperAbility(String superAbility) {
        this.superAbility.add(superAbility);
    }

}
