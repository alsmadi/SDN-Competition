/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdn_competition;

import prefuse.action.Action;

public class UnlockAction extends Action {

	Data d;
	
	public UnlockAction(Data d)
	{
		this.d = d;
	}
	
	@Override
	public void run(double arg0) {
		d.getLock().unlock();
	}

}
