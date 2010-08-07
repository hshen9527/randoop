package randoop.plugin.internal.ui.views;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import randoop.plugin.model.resultstree.IRandoopTreeElement;
import randoop.plugin.model.resultstree.RunResultsTree;

public class RandoopContentProvider implements ITreeContentProvider {
 
  private RunResultsTree root;
  public TreeViewer viewer;
  
  public RandoopContentProvider(RunResultsTree root) {
    this.root = root; 
  }
 
  @Override
  public void dispose() {
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    if (viewer instanceof TreeViewer) {
      this.viewer = (TreeViewer) viewer;
    }
    if (newInput instanceof RunResultsTree) {
      root = (RunResultsTree)newInput;
    }
  }

  @Override
  public Object[] getChildren(Object element) {
    if (element instanceof IRandoopTreeElement) {
      return ((IRandoopTreeElement)element).getChildren();
    }
    return new Object[0];
  }

  @Override
  public Object getParent(Object element) {
    if (element instanceof IRandoopTreeElement) {
      return ((IRandoopTreeElement)element).getParent();
    }
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  @Override
  public Object[] getElements(Object element) {
    return getChildren(element);
  }
}
