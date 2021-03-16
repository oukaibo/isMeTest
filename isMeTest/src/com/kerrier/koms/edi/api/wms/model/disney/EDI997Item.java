package com.kerrier.koms.edi.api.wms.model.disney;

import java.io.Serializable;
import java.util.List;

/**
 * EDI 997 segment
 * @author hd
 *
 */
public class EDI997Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ST st;
	private AK1 ak1;
	private List<EDIAKItem> items;
	private AK9 ak9;
	private SE se;

	public ST getSt() {
		return st;
	}

	public void setSt(ST st) {
		this.st = st;
	}

	public AK1 getAk1() {
		return ak1;
	}

	public void setAk1(AK1 ak1) {
		this.ak1 = ak1;
	}

	public List<EDIAKItem> getItems() {
		return items;
	}

	public void setItems(List<EDIAKItem> items) {
		this.items = items;
	}

	public AK9 getAk9() {
		return ak9;
	}

	public void setAk9(AK9 ak9) {
		this.ak9 = ak9;
	}

	public SE getSe() {
		return se;
	}

	public void setSe(SE se) {
		this.se = se;
	}

	@Override
	public String toString() {
		
		StringBuffer desc = new StringBuffer();

        desc.append(st + "\n");
        desc.append(ak1 + "\n");
        
        for(int i = 0; i < items.size(); i++) {
            desc.append(items.get(i)).append("\n");
        }
        
        desc.append(ak9 + "\n");       
        desc.append(se + "\n");        

        return desc.toString();
	}

}
