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
package org.eclipse.ui;

import org.eclipse.core.resources.IMarker;

/**
 * Resolution for a marker. When run, a resolution would
 * typically eliminate the need for the marker.
 *
 * @since 2.0
 */
public interface IMarkerResolution {
	/**
	 * Returns a short label indicating what the resolution will do.
	 *
	 * @return a short label for this resolution
	 */
	public String getLabel();

	/**
	 * Runs this resolution.
	 *
	 * @param marker the marker to resolve
	 */
	public void run(IMarker marker);
}

