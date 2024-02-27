package entities;

import Interfaces.*;
import items.Accessory;
import items.Crock;
import items.Food;
import items.Item;
import other.Feeling;

public abstract class Entity implements IEat, IPutOn, ISee, ITalk, IFeel {
    private String name;
    private int age;
    private boolean isMale;


    public Entity(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;

    }


    // ЛОКАЛЬНЫЙ КЛАСС
    public void thinkAbout(Animal animal, boolean isGoodRelationship){
        class Thought{
            private String description;

            public Thought(boolean isMale, Animal animal, boolean isGoodRelationship){
                if (isMale()){
                    if (isGoodRelationship) this.description = "с уважением относится к " + animal.getName();
                    else this.description = "не уважает " + animal.getName();
                }
                else {
                    if (isGoodRelationship) this.description = "с любовью относится к " + animal.getName();
                    else this.description = "не любит " + animal.getName();
                }

            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }


        }
        System.out.println(this.getName() + " думает о " + animal.getName());
        Thought thought = new Thought(this.isMale(), animal, isGoodRelationship);
        System.out.println(this.getName() + " " + thought.getDescription());
    }

    // ВНУТРЕННИЙ STATIC
    public static class Animal implements IEat {
        private String name;
        private String type;
        private boolean isMale;

        public Animal(String name, String type, boolean isMale) {
            this.name = name;
            this.type = type;
            this.isMale = isMale;
        }

        public void doSomething(String action) {
            System.out.println(this.getName() + " " + action);
        }

        @Override
        public void toEat(Food food) {
            if (this.isMale())
                System.out.println(this.getName() + " съел " + food.getName());
            else System.out.println(this.getName() + " съела " + food.getName());
        }

        @Override
        public void toEat(Crock crock) {
            System.out.println(this.getName() + " не может съесть " + crock.getName());
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isMale() {
            return isMale;
        }

        public void setMale(boolean male) {
            isMale = male;
        }

    }

    // ВНУТРЕННИЙ STATIC
    public static class Enemy {
        private String name;
        private String type;
        private Weapon weapon;

        public Enemy(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public void suppress(Animal entity, Weapon weapon) {
            System.out.println(this.type + " " + this.name + " подавляет " + entity.getName() + " (" + entity.getType() + ")" + " при помощи оружия: " + weapon.getName());
        }

        // ВНУТРЕННИЙ NON-STATIC
        public class Weapon {
            private String name;

            public Weapon(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }
    }

    public void doSomething(String action) {
        System.out.println(this.getName() + " " + action);
    }

    // АНОНИМНЫЙ КЛАСС
    public void interact(Entity entity, String action) {
        System.out.println(this.getName() + " начианет " + action + " с " + entity.getName());
        if (action.equals("допрос")) {
            toInterrogate(new IInterrogate() {
                public String toInterrogate(Entity entity) {
                    if (entity.getAge() > 40) {
                        return entity.getName() + " и не подумает давать показания";
                    } else {
                        if (entity.isMale())
                            return entity.getName() + " готов дать показания";
                        else return entity.getName() + " готова дать показания";
                    }
                }

            }, entity);
        }
    }

    public void toInterrogate(IInterrogate x, Entity entity) {
        System.out.println(x.toInterrogate(entity));
    }

    @Override
    public void toPutOn(Accessory item) {
        if (this.isMale())
            System.out.println(this.getName() + " надел " + item.getName());
        else System.out.println(this.getName() + " надела " + item.getName());
    }

    @Override
    public void toEat(Food food) {
        if (this.isMale())
            System.out.println(this.getName() + " съел " + food.getName());
        else System.out.println(this.getName() + " съела " + food.getName());
    }


    @Override
    public void toWatch(Item item, String description) {
        if (this.isMale())
            System.out.println(this.getName() + " " + description + " посмотрел на предмет: " + item.getName());
        else System.out.println(this.getName() + " " + description + " посмотрела на предмет: " + item.getName());
    }

    @Override
    public void toWatch(UsualPerson person, String description) {
        if (this.isMale())
            System.out.println(this.getName() + " " + description + " посмотрел на персонажа: " + person.getName());
        else System.out.println(this.getName() + " " + description + " посмотрела на персонажа: " + person.getName());
    }

    @Override
    public void toWatch(FairyPerson person, String description) {
        if (this.isMale())
            System.out.println(this.getName() + " " + description + " посмотрел на сказаочного персонажа: " + person.getName());
        else
            System.out.println(this.getName() + " " + description + " посмотрела на сказаочного персонажа: " + person.getName());
    }

    @Override
    public void sayPhrase(String phrase) {
        if (this.isMale())
            System.out.println(this.getName() + " сказал:");
        else System.out.println(this.getName() + " сказала:");
        System.out.println("- " + phrase);
    }

    @Override
    public void toFeel(Feeling feeling) {
        if (this.isMale())
            System.out.println(this.getName() + " чувствовал себя " + feeling.getDescription() + "\nИз-за этого он начал " + feeling.getAction());
        else
            System.out.println(this.getName() + " чувствовала себя " + feeling.getDescription() + "\nИз-за этого она начала " + feeling.getAction());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }
}
