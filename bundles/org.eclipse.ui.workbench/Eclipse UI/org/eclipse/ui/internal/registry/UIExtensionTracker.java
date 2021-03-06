/*******************************************************************************
 * Copyright (c) 2005, 2014 IBM Corporation and others.
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
package org.eclipse.ui.internal.registry;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.WorkbenchPlugin;

/**
 * @since 3.1
 */
public class UIExtensionTracker extends ExtensionTracker {
	private Display display;

	// SOMETHING HAS NOT BEEN DONE IN THE REGISTTRY CHANGED CODE
	// if (!PlatformUI.isWorkbenchRunning())
	// return;
	// int numDeltas = 0;
	// Display display = PlatformUI.getWorkbench().getDisplay();
	// if (display == null || display.isDisposed())
	// return;
	// It seems that the tracker should be closed.

	/**
	 * @param display
	 */
	public UIExtensionTracker(Display display) {
		this.display = display;
	}

	@Override
	protected void applyRemove(final IExtensionChangeHandler handler, final IExtension removedExtension,
			final Object[] objects) {
		if (display.isDisposed())
			return;

		display.asyncExec(() -> {
			try {
				handler.removeExtension(removedExtension, objects);
			} catch (Exception e) {
				WorkbenchPlugin.log(getClass(), "doRemove", e); //$NON-NLS-1$
			}
		});
	}

	@Override
	protected void applyAdd(final IExtensionChangeHandler handler, final IExtension addedExtension) {
		if (display.isDisposed())
			return;

		display.asyncExec(() -> {
			try {
				handler.addExtension(UIExtensionTracker.this, addedExtension);
			} catch (Exception e) {
				WorkbenchPlugin.log(getClass(), "doAdd", e); //$NON-NLS-1$
			}
		});
	}
}
