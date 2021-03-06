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
 * IBM - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.internal.ide.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.dialogs.CleanDialog;

/**
 * The clean action replaces the rebuild actions. Clean will discard all built
 * state for all projects in the workspace, and deletes all problem markers.
 * The next time a build is run, projects will have to be built from scratch.
 * Technically this is only necessary if an incremental builder misbehaves.
 *
 * @since 3.0
 */
public class BuildCleanAction extends Action implements ActionFactory.IWorkbenchAction {
	private IWorkbenchWindow window;

	/**
	 * Creates a new BuildCleanAction
	 *
	 * @param window The window for parenting this action
	 */
	public BuildCleanAction(IWorkbenchWindow window) {
		super(IDEWorkbenchMessages.Workbench_buildClean);
		setActionDefinitionId("org.eclipse.ui.project.cleanAction"); //$NON-NLS-1$
		this.window = window;
	}

	@Override
	public void dispose() {
		window = null;
	}

	@Override
	public void run() {
		IProject[] selected = BuildUtilities.findSelectedProjects(window);
		new CleanDialog(window, selected).open();
	}
}
