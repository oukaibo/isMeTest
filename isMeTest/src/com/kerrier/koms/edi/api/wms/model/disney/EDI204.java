package com.kerrier.koms.edi.api.wms.model.disney;

import java.util.List;

public class EDI204 {

	private ISA isa;
	private GS gs;
	private List<EDI204Item> items;
	private GE ge;
	private IEA iea;
	public ISA getIsa() {
		return isa;
	}
	public void setIsa(ISA isa) {
		this.isa = isa;
	}
	public GS getGs() {
		return gs;
	}
	public void setGs(GS gs) {
		this.gs = gs;
	}
	public List<EDI204Item> getItems() {
		return items;
	}
	public void setItems(List<EDI204Item> items) {
		this.items = items;
	}
	public GE getGe() {
		return ge;
	}
	public void setGe(GE ge) {
		this.ge = ge;
	}
	public IEA getIea() {
		return iea;
	}
	public void setIea(IEA iea) {
		this.iea = iea;
	}
	
}
