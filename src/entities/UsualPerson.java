package entities;

import items.Crock;

public class UsualPerson extends Entity {
    public UsualPerson(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    @Override
    public void toEat(Crock crock) {
        System.out.println(this.getName() + " не может съесть " + crock.getName());
    }
}
