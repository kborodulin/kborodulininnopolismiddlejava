package ru.innopolis.dz_8.task_1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class App implements Serialization {
    private String pathPackage = this.getClass().getPackage().getName();
    private TextUtils textUtils = new TextUtils();
    private StringBuilder stringBuilder = new StringBuilder();
    private FileOperation fileOperation = new FileOperation();

    @Override
    public void serialize(Object object, String file) throws InvocationTargetException, IllegalAccessException, IOException {
        stringBuilder.append("{\n");

        for (Method method : object.getClass().getDeclaredMethods()) {
            // Обработка ссылочных типов
            if (method.getReturnType().getName().startsWith(pathPackage)) {
                stringBuilder.append(method.invoke(object));
            } else {
                // Обработка примитивов
                if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                    stringBuilder.append("\t\"" +
                            textUtils.removePrefix(method.getName()) +
                            "\":" +
                            textUtils.quotesText(method.invoke(object).toString()) + ",\n");
                }
            }
        }

        if (stringBuilder.charAt(stringBuilder.length() - 2) == ',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 2);
            stringBuilder.append("}");
        } else {
            stringBuilder.append("}");
        }

        fileOperation.writeFile(file, stringBuilder.toString());
    }

    @Override
    public Object deSerialize(String file) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<String> strings = fileOperation.readFile(file);
        Class<?> aClassPerson = Class.forName(pathPackage + "." + "Person");
        Person person = (Person) aClassPerson.newInstance();
        Class<?> aClassPassport = Class.forName(pathPackage + "." + "Passport");
        Passport passport = (Passport) aClassPassport.newInstance();

        for (Method method : aClassPassport.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                for (String str : strings) {
                    if (str.indexOf(method.getName().substring(3).toLowerCase()) == 3 && !str.endsWith("{")) {
                        str = textUtils.removeComma(str.substring(str.indexOf("\":") + 2));
                        method.invoke(passport, textUtils.castText(str));
                        System.out.println(str);
                        break;
                    }
                }
            }
        }

        for (Method method : aClassPerson.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                for (String str : strings) {
                    if (str.indexOf(method.getName().substring(3).toLowerCase()) == 2 && !str.endsWith("{")) {
                        str = textUtils.removeComma(str.substring(str.indexOf("\":") + 2));
                        method.invoke(person, textUtils.castText(str));
                        break;
                    }
                }
                if ("setPassport".equals(method.getName())) {
                    method.invoke(person, passport);
                }

            }
        }

        return person;
    }
}