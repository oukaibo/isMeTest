package com.kerrier.koms.edi.api.wms.model.disney;

import java.util.List;

public class OIDItem {

	private OID oid;
	private L5 l5;
	private List<G61Item> g61Items;
	
	public List<G61Item> getG61Items() {
		return g61Items;
	}
	public void setG61Items(List<G61Item> g61Items) {
		this.g61Items = g61Items;
	}
	public OID getOid() {
		return oid;
	}
	public void setOid(OID oid) {
		this.oid = oid;
	}
	public L5 getL5() {
		return l5;
	}
	public void setL5(L5 l5) {
		this.l5 = l5;
	}
	
	
}
