package com.kerrier.koms.edi.api.wms.model.disney;

import java.util.List;

public class EDI204ChildItem {

	private S5 s5;
	private G62 g62;
	private AT8 at8;
	private PLD pld;
	private List<NTE> nteItems;
	private N1 n1;
	private N3 n3;
	private N4 n4;
	private List<OIDItem> oidItems;

	public S5 getS5() {
		return s5;
	}
	public void setS5(S5 s5) {
		this.s5 = s5;
	}
	public G62 getG62() {
		return g62;
	}
	public void setG62(G62 g62) {
		this.g62 = g62;
	}
	public AT8 getAt8() {
		return at8;
	}
	public void setAt8(AT8 at8) {
		this.at8 = at8;
	}
	public PLD getPld() {
		return pld;
	}
	public void setPld(PLD pld) {
		this.pld = pld;
	}
	public N1 getN1() {
		return n1;
	}
	public void setN1(N1 n1) {
		this.n1 = n1;
	}
	public N3 getN3() {
		return n3;
	}
	public void setN3(N3 n3) {
		this.n3 = n3;
	}
	public N4 getN4() {
		return n4;
	}
	public void setN4(N4 n4) {
		this.n4 = n4;
	}
	public List<OIDItem> getOidItems() {
		return oidItems;
	}
	public void setOidItems(List<OIDItem> oidItems) {
		this.oidItems = oidItems;
	}
	public List<NTE> getNteItems() {
		return nteItems;
	}
	public void setNteItems(List<NTE> nteItems) {
		this.nteItems = nteItems;
	}
	
}
