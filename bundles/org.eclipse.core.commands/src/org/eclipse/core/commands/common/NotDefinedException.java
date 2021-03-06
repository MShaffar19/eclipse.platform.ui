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
package org.eclipse.core.commands.common;

/**
 * Signals that an attempt was made to access the properties of an undefined
 * object.
 * <p>
 * This class is not intended to be extended by clients.
 * </p>
 *
 * @since 3.1
 */
public final class NotDefinedException extends CommandException {

	/**
	 * Generated serial version UID for this class.
	 *
	 * @since 3.1
	 */
	private static final long serialVersionUID = 3257572788998124596L;

	/**
	 * Creates a new instance of this class with the specified detail message.
	 *
	 * @param s
	 *            the detail message; may be <code>null</code>.
	 */
	public NotDefinedException(final String s) {
		super(s);
	}
}
