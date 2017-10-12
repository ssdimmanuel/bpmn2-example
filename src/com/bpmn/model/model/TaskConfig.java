/**
 */
package com.bpmn.model.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.bpmn.model.model.TaskConfig#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see com.bpmn.model.model.ModelPackage#getTaskConfig()
 * @model
 * @generated
 */
public interface TaskConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.bpmn.model.model.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.bpmn.model.model.ModelPackage#getTaskConfig_Parameters()
	 * @model containment="true"
	 *        extendedMetaData="name='parameter' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // TaskConfig
