import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class TestClass {

    @Test
    public void test() {

        Injector guice = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {

                install(new FactoryModuleBuilder().implement(IWidget.class, Widget.class)
                                                  .build(WidgetFactory.class));

            }
        });

        WidgetFactory widgetFactory = guice.getInstance(WidgetFactory.class);

        IWidget b = widgetFactory.create("B");
        assertEquals("B", b.getName());

        IWidget child = b.getChild();
        assertNotNull(child);
        assertEquals("C", child.getName());
    }

}
