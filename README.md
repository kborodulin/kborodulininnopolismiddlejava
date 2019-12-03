# kborodulininnopolismiddlejava

ДЗ_2

Задание 1. Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение и завершиться 
с ошибкой.
    Смоделировав ошибку «NullPointerException»
    Смоделировав ошибку «ArrayIndexOutOfBoundsException»
    Вызвав свой вариант ошибки через оператор throw

Задание 2. Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q. 
Если квадрат целой части q числа равен k, то вывести это число на экран. Предусмотреть что первоначальные числа могут 
быть отрицательные, в этом случае генерировать исключение.

Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100), 
sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка). Создать два класса, 
методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс для классов сортировки. 
Реализовать два различных метода сортировки этого массива по правилам:
    первые идут мужчины
    выше в списке тот, кто более старший
    имена сортируются по алфавиту
Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
Предусмотреть генерацию исходного массива (10000 элементов и более).
Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.


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


ДЗ_5

Разработать программу – картотеку домашних животных. 
У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
Реализовать:
    метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
    поиск животного по его кличке (поиск должен быть эффективным)
    изменение данных животного по его идентификатору
    вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес. 

   
ДЗ_6

Задание 1. Написать программу, читающую текстовый файл. Программа должна составлять отсортированный по алфавиту список слов, 
найденных в файле и сохранять его в файл-результат. Найденные слова не должны повторяться, регистр не должен учитываться. 
Одно слово в разных падежах – это разные слова.

Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
    Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
    Слово состоит из 1<=n2<=15 латинских букв
    Слова разделены одним пробелом
    Предложение начинается с заглавной буквы
    Предложение заканчивается (.|!|?)+" "
    Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
    Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability), который создаст n 
файлов размером size в каталоге path. words - массив слов, probability - вероятность.        
По сути, есть несколько способа решения задания:
1) распараллеливать вычисление факториала для одного числа
2) распараллеливать вычисления для разных чисел
3) комбинированный
При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого, 
что будет гораздо быстрее


ДЗ_7
Дан массив случайных чисел. 
Написать программу для вычисления факториалов всех элементов массива. 
Использовать пул потоков для решения задачи.

Особенности выполнения:
Для данного примера использовать рекурсию - не очень хороший вариант, 
т.к. происходит большое выделение памяти, очень вероятен StackOverFlow. 
Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger

Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox. 
Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться. 
При попытке положить Object в MathBox должно создаваться исключение.


ДЗ_8
Задание 1. Необходимо разработать класс, реализующий следующие методы:
void serialize (Object object, String file);
Object deSerialize(String file);
Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла. 
Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).

Задание 2. Предусмотреть работу c любыми типами полей (полями могут быть ссылочные типы).
Требование: Использовать готовые реализации (Jaxb, jackson и т.д.) запрещается.


ДЗ_9

Дан интерфейс
public interface Worker {
    void doWork();
}
Необходимо написать программу, выполняющую следующее:
Программа с консоли построчно считывает код метода doWork. 
Код не должен требовать импорта дополнительных классов.
После ввода пустой строки считывание прекращается и считанные строки добавляются 
в тело метода public void doWork() в файле SomeClass.java.
Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
Полученный файл подгружается в программу с помощью кастомного загрузчика
Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)


ДЗ_13
Задание 1. Взять за основу одну из предметных областей:
     система тестирования для студентов
     онлайн-магазин с возможностью покупки товаров
     социальная сеть с возможностью отправки приватных сообщений и загрузки фотографий
     блог с возможностью публикации статей и ограничением доступа для просмотра пользователям
Задание 2. Описать предметную область с помощью изученных на занятии диаграмм:
    Общая use-case диаграмма
    sequence диаграмма
    activity диаграмма (на отдельные фичи программы)
    Общая диаграмма классов (свое видение на текущий момент)

