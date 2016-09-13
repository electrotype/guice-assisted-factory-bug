import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class Widget implements IWidget {

    private final WidgetFactory widgetFactory;
    private final String name;
    private IWidget child;

    @AssistedInject
    public Widget(@Assisted String name,
                  WidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
        this.name = name;
    }

    @Inject
    protected void init() {
        if("B".equals(getName())) {
            this.child = getWidgetFactory().create("C");
        }
    }

    protected WidgetFactory getWidgetFactory() {
        return this.widgetFactory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public IWidget getChild() {
        return this.child;
    }

}
