/*******************************************************************************
 * Copyright (c) 2004, 2015 IBM Corporation and others.
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
package org.eclipse.jface.bindings;

/**
 * <p>
 * The abstract class for any object that can be used as a trigger for a binding.
 * This ensures that trigger conform to certain minimum requirements. Namely, triggers
 * need to be hashable.
 * </p>
 *
 * @since 3.1
 */
public abstract class Trigger implements Comparable {

	/**
	 * Tests whether this object is equal to another object. A handle object is
	 * only equal to another trigger with the same properties.
	 *
	 * @param object
	 *            The object with which to compare; may be <code>null</code>.
	 * @return <code>true</code> if the objects are equal; <code>false</code>
	 *         otherwise.
	 */
	@Override
	public abstract boolean equals(final Object object);

	/**
	 * Computes the hash code for this object.
	 *
	 * @return The hash code for this object.
	 */
	@Override
	public abstract int hashCode();
}
