/******************************************************************************* * Copyright (c) 2005 IBM Corporation and others. * All rights reserved. This program and the accompanying materials * are made available under the terms of the Eclipse Public License v1.0 * which accompanies this distribution, and is available at * http://www.eclipse.org/legal/epl-v10.html * * Contributors: *     IBM Corporation - initial API and implementation ******************************************************************************/package org.eclipse.ui.internal.expressions;import org.eclipse.core.expressions.EvaluationResult;import org.eclipse.core.expressions.Expression;import org.eclipse.core.expressions.ExpressionInfo;import org.eclipse.core.expressions.IEvaluationContext;import org.eclipse.core.runtime.CoreException;import org.eclipse.jface.viewers.IStructuredSelection;import org.eclipse.ui.IWorkbenchWindow;import org.eclipse.ui.internal.ActionExpression;/** * <p> * This wrappers the old {@link ActionExpression} class so that it can * communicate via the {@link Expression} contract. * </p> * <p> * This class is not intended for use outside of the * <code>org.eclipse.ui.workbench</code> plug-in. * </p> * <p> * <strong>EXPERIMENTAL</strong>. This class or interface has been added as * part of a work in progress. There is a guarantee neither that this API will * work nor that it will remain the same. Please do not use this API without * consulting with the Platform/UI team. * </p> *  * @since 3.2 */public final class LegacyActionExpressionWrapper extends		WorkbenchWindowExpression {	/**	 * The legacy action expression being wrapped; never <code>null</code>.	 */	private final ActionExpression expression;	/**	 * Constructs a new instance of {@link LegacyActionExpressionWrapper}.	 * 	 * @param expression	 *            The expression to wrap; must not be <code>null</code>.	 * @param window	 *            The workbench window which must be active for this expression	 *            to evaluate to <code>true</code>; may be <code>null</code>	 *            if the window should be disregarded.	 */	public LegacyActionExpressionWrapper(final ActionExpression expression,			final IWorkbenchWindow window) {		super(window);		if (expression == null) {			throw new NullPointerException(					"The action expression cannot be null"); //$NON-NLS-1$		}		this.expression = expression;	}	public final void collectExpressionInfo(final ExpressionInfo info) {		super.collectExpressionInfo(info);		info.markDefaultVariableAccessed();	}	public final EvaluationResult evaluate(final IEvaluationContext context)			throws CoreException {		final EvaluationResult result = super.evaluate(context);		if (result == EvaluationResult.FALSE) {			return result;		}		final Object defaultVariable = context.getDefaultVariable();		if (defaultVariable instanceof IStructuredSelection) {			final IStructuredSelection selection = (IStructuredSelection) defaultVariable;			if (expression.isEnabledFor(selection)) {				return EvaluationResult.TRUE;			}		} else if (expression.isEnabledFor(defaultVariable)) {			return EvaluationResult.TRUE;		}		return EvaluationResult.FALSE;	}	public final String toString() {		final StringBuffer buffer = new StringBuffer();		buffer.append("LegacyActionExpressionWrapper("); //$NON-NLS-1$		buffer.append(expression);		buffer.append(',');		buffer.append(getWindow());		buffer.append(')');		return buffer.toString();	}}