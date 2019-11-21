package ru.innopolis.dz_8.task_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App implements Serialization {
    @Override
    public void serialize(Object object, String file) throws InvocationTargetException, IllegalAccessException {
        Json json = new Json();
        Class objectClass = object.getClass();
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                json.jsonFormatUnload(method.getName().substring(3).toLowerCase());
                json.jsonFormatUnload(method.invoke(object).toString());
            }
        }

        System.out.println(json.getBuilder());


        //ethod.setAccessible(true);

        //  System.out.println(name);




  /*      Method[] methods = objectClass.getDeclaredMethods();


                for (Method method : methods) {
                    System.out.println("getter: " + method);
                    if (method.getName().startsWith("get")) {
                        System.out.println(method.invoke(objectClass.getDeclaringClass()));
                    }*/
        // System.out.println(method.getName().startsWith("get"));
        //   method.invoke(object);
        //  System.out.println(method.getName());
        //      System.out.println(method.invoke(object));


        //  Field field = objectClass.getField("name");
        //     System.out.println(field.get(field));

/*        for (Method method : methods) {
            System.out.println(method.invoke(object), new Object[]{null});
         //   method.invoke(object);
         //  System.out.println(method.getName());
      //      System.out.println(method.invoke(object));
        }*/

        //   Field[] declaredFields = objectClass.getDeclaredFields();
        //     for(Field f:declaredFields){

        //         System.out.println(f.get(objectClass));
        //      }

/*


        Field[] fields = person.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field.getName());
            System.out.println(field.getInt(person));
        }*/
    }

    @Override
    public Object deSerialize(String file) {

        return null;
    }
}