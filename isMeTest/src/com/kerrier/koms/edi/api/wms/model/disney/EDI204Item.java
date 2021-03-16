package com.kerrier.koms.edi.api.wms.model.disney;

import java.util.List;

public class EDI204Item {

	private ST st;
	private B2 b2;
	private B2A b2a;
	private L11 l11;
	private G62 g62;
	private AT5 at5;
	private N7 n7;
	private M7 m7;
	private List<EDI204ChildItem> childItems;
	private L3 l3;
	private SE se;
	public ST getSt() {
		return st;
	}
	public void setSt(ST st) {
		this.st = st;
	}
	public B2 getB2() {
		return b2;
	}
	public void setB2(B2 b2) {
		this.b2 = b2;
	}
	public B2A getB2a() {
		return b2a;
	}
	public void setB2a(B2A b2a) {
		this.b2a = b2a;
	}
	public L11 getL11() {
		return l11;
	}
	public void setL11(L11 l11) {
		this.l11 = l11;
	}
	public G62 getG62() {
		return g62;
	}
	public void setG62(G62 g62) {
		this.g62 = g62;
	}
	public AT5 getAt5() {
		return at5;
	}
	public void setAt5(AT5 at5) {
		this.at5 = at5;
	}
	public N7 getN7() {
		return n7;
	}
	public void setN7(N7 n7) {
		this.n7 = n7;
	}
	
	public M7 getM7() {
		return m7;
	}
	public void setM7(M7 m7) {
		this.m7 = m7;
	}
	public List<EDI204ChildItem> getChildItems() {
		return childItems;
	}
	public void setChildItems(List<EDI204ChildItem> childItems) {
		this.childItems = childItems;
	}
	public L3 getL3() {
		return l3;
	}
	public void setL3(L3 l3) {
		this.l3 = l3;
	}
	public SE getSe() {
		return se;
	}
	public void setSe(SE se) {
		this.se = se;
	}
	
	
}
