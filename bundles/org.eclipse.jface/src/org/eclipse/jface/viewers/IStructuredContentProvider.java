/*******************************************************************************
 * Copyright (c) 2000, 2015 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.viewers;

/**
 * An interface to content providers for structured viewers.
 *
 * @see StructuredViewer
 */
public interface IStructuredContentProvider extends IContentProvider {
	/**
	 * Returns the elements to display in the viewer
	 * when its input is set to the given element.
	 * These elements can be presented as rows in a table, items in a list, etc.
	 * The result is not modified by the viewer.
	 *
	 * @param inputElement the input element
	 * @return the array of elements to display in the viewer
	 */
	public Object[] getElements(Object inputElement);
}
