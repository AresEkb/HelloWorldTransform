package HelloWorldHenshin;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class Main {

    public static void main(String[] args) {
        HenshinResourceSet resourceSet = new HenshinResourceSet("model");
        Module module = resourceSet.getModule("HelloWorld.henshin", false);
        EGraph graph = new EGraphImpl(resourceSet.getResource("MyModel2.xmi"));
        Engine engine = new EngineImpl();

        UnitApplication app = new UnitApplicationImpl(engine);
        app.setEGraph(graph);
        app.setUnit(module.getUnit("main"));

        if (!app.execute(null)) {
            throw new RuntimeException("Execution error");
        }

        resourceSet.saveEObject(graph.getRoots().get(0), "MyModel3.xmi");
    }

}
