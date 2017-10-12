package bpmn_runtime;

import java.util.List;

import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.DefaultPropertySection;
import org.eclipse.bpmn2.modeler.core.model.ModelDecorator;
import org.eclipse.bpmn2.modeler.core.runtime.CustomTaskDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;

import com.bpmn.model.model.ModelFactory;
import com.bpmn.model.model.ModelPackage;
import com.bpmn.model.model.TaskConfig;

public class MyTaskPropertySection extends DefaultPropertySection {

	public MyTaskPropertySection() {
		super();
	}

	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new MyTaskDetailComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new MyTaskDetailComposite(parent, style);
	}

	public class MyTaskDetailComposite extends DefaultDetailComposite {

		public MyTaskDetailComposite(AbstractBpmn2PropertySection section) {
			super(section);
			System.out.println("Creating composite#1");
		}

		public MyTaskDetailComposite(Composite parent, int style) {
			super(parent, style);
			System.out.println("Creating composite#2");
		}

		@Override
		public void createBindings(EObject be) {
			Task myTask = (Task) be;
			TaskConfig taskConfig = null;
			
			System.out.println("Inside a task: "+myTask);
			
			
			List<TaskConfig> allTaskConfigs = ModelDecorator.getAllExtensionAttributeValues(myTask, TaskConfig.class);
			
			System.out.println("taskconfig count "+allTaskConfigs.size());
			if (allTaskConfigs.size() == 0) {
				taskConfig = ModelFactory.eINSTANCE.createTaskConfig();
				TargetRuntime rt = getTargetRuntime();
				
				rt.getCustomTaskDescriptors();
				for(CustomTaskDescriptor ctd : rt.getCustomTaskDescriptors()){
					EStructuralFeature feature = ctd.getModelDecorator().getEStructuralFeature(be, "taskConfig");
					ModelDecorator.addExtensionAttributeValue(myTask, feature, taskConfig, true);
				}
				
			} else {
				// Else reuse the existing TaskConfig object.
				taskConfig = allTaskConfigs.get(0);
			}
			// Display the Parameters list in TaskConfig
			bindList(taskConfig, ModelPackage.eINSTANCE.getTaskConfig_Parameters());
		}
	}
}
