import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {

    public static void processAnnotations(Object object){

        try{

            Class<?> cl = object.getClass();
            for (Method m: cl.getDeclaredMethods()){

                ActionListenerFor actionListenerFor = m.getAnnotation(ActionListenerFor.class);
                if (actionListenerFor != null){

                    Field f = cl.getDeclaredField(actionListenerFor.source());
                    f.setAccessible(true);
                    addListener(f.get(object),object,m);
                }
            }
        }catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    public static void addListener(Object source, final Object param, final Method m)
        throws ReflectiveOperationException{

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };

        Object listener = Proxy.newProxyInstance(null,
                new Class[] { java.awt.event.ActionListener.class},handler);
        Method adder = source.getClass().getMethod("addActionListener",ActionListener.class);
        adder.invoke(source,listener);
    }
}
