import Exceptions.EatItemException;
import Exceptions.WrongSuperAbilityException;
import entities.Entity;
import entities.FairyPerson;
import entities.UsualPerson;
import items.Accessory;
import items.Crock;
import other.Feeling;

public class Main {
    public static void main(String[] args) {
        UsualPerson king = new UsualPerson("Король", 50, true);
        UsualPerson quin = new UsualPerson("Королева", 45, false);

        FairyPerson alisa = new FairyPerson("Алиса", 17, false);
        alisa.addSuperAbility("расти до размеров большого дерева");

        FairyPerson hat = new FairyPerson("Шляпа", 20, true);
        hat.addSuperAbility("танцевать Жигу-Дрыгу");

        Accessory glass = new Accessory("Очки");
        Crock cup = new Crock("Чашка");
        quin.toFeel(Feeling.Serious);
        quin.toPutOn(glass);
        quin.toWatch(hat, "пристально");
        king.sayPhrase("Свидетель, давайте показания, и не волнуйтесь, не то я велю казнить вас на месте.");
        hat.doSomething("побледнел");
        hat.toFeel(Feeling.Nervous);
        hat.toWatch(quin, "неуверенно");

        // ПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ
        try {
            hat.toEat(cup);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        // НЕПРОВЕРЯЕМОЕ ИСКЛЮЧЕНИЕ
        try {
            alisa.getSuperAbility(0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        alisa.toFeel(Feeling.Unusual);



        hat.doSomething("опустился на одно колено");

        Entity.Animal filin = new Entity.Animal("Филин", "филин", true);
        hat.thinkAbout(filin, true);

        Entity.Animal pig1 = new Entity.Animal("Поли", "свинка", true);
        Entity.Animal pig2 = new Entity.Animal("Моли", "свинка", true);
        Entity.Enemy solder = new Entity.Enemy("Адриан", "солдат");

        Entity.Enemy.Weapon bag = solder.new Weapon("мешок");

        pig1.doSomething("начала аплодировать");
        solder.suppress(pig1, bag);

        alisa.toFeel(Feeling.Happy);
        alisa.sayPhrase("Я очень рада, что увидела, как это делается");

        pig2.doSomething("начала аплодировать");
        solder.suppress(pig2, bag);

        king.sayPhrase("Вызвать свидетельницу");
        UsualPerson cock = new UsualPerson("Кухарка", 50, false);
        king.interact(cock, "допрос");
    }
}


