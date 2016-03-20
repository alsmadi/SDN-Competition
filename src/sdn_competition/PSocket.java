/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdn_competition;

import java.net.InetAddress;

/**
 *
 * @author IAlsmadi
 */
public class PSocket {
	InetAddress addr;
	int port;
	public PSocket(InetAddress a, int p) {
		addr = a; port = p;
	}
	public int getPort() {return port;}
	public InetAddress getAddr() {return addr;}
	public String toString() {
		String theString = "<";
		theString = theString + addr.getHostAddress();
		theString = theString + ",";
		theString = theString + port;
		theString = theString + ">";
		return theString;
	}
        // .equals method for comparing PSocket objects
	public boolean equals(Object o) {
		if (! (o instanceof PSocket)) return false;
		PSocket p = (PSocket) o;
		if (getPort() == p.getPort() && getAddr().equals(p.getAddr())) {
			return true;
		} else {
			return false;
		}
	}
	// when you implement .equals, you must also implement this:
	// "^" means XOR; the 37 is there to make it asymmetric
	public int hashCode() {
		return addr.hashCode() ^ (37*port);
	}
    }

