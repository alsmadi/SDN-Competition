/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdn_competition;

import prefuse.data.Edge;
import prefuse.data.Node;
import prefuse.data.Tuple;

public interface SelectListener {
	public void nodeSelected(Node n);
	public void edgeSelected(Edge e);
	public void groupSelected(Node n);
	public void selectionCleared();
}
