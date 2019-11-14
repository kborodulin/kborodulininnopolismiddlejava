# kborodulininnopolismiddlejava

ДЗ_3

Задание 1. Написать класс MathBox, реализующий следующий функционал:

        Конструктор на вход получает массив Number. Элементы не могут повторяться. 
        Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
        Существует метод summator, возвращающий сумму всех элементов коллекции.
        Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, 
        являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
        Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать 
        MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
        Выполнение контракта обязательно!
        Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.


Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.

        У класса должен быть метод addObject, добавляющий объект в коллекцию.
        У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
        Должен быть метод dump, выводящий содержимое коллекции в строку.


Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox. 
Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться. 
При попытке положить Object в MathBox должно создаваться исключение.
