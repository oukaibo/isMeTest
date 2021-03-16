package com.kerrier.koms.edi.api.wms.model.disney;

import java.io.Serializable;

/**
 * EDI 997 AK2~AK5
 * @author hd
 *
 */
public class EDIAKItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private AK2 ak2;
	private AK3 ak3;
	private AK4 ak4;
	private AK5 ak5;

	public AK2 getAk2() {
		return ak2;
	}

	public void setAk2(AK2 ak2) {
		this.ak2 = ak2;
	}

	public AK3 getAk3() {
		return ak3;
	}

	public void setAk3(AK3 ak3) {
		this.ak3 = ak3;
	}

	public AK4 getAk4() {
		return ak4;
	}

	public void setAk4(AK4 ak4) {
		this.ak4 = ak4;
	}

	public AK5 getAk5() {
		return ak5;
	}

	public void setAk5(AK5 ak5) {
		this.ak5 = ak5;
	}

	@Override
	public String toString() {
		return "EDIAKItem [ak2=" + ak2 + ", ak3=" + ak3 + ", ak4=" + ak4
				+ ", ak5=" + ak5 + "]";
	}

}
