package com.kerrier.koms.edi.api.wms.model.disney;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;

import org.milyn.edisax.model.internal.Delimiters;
import org.milyn.smooks.edi.EDIWritable;


/**
 * EDI 997 标准协议内容
 * @author hd
 *
 */
public class EDI997 implements Serializable, EDIWritable{

	private static final long serialVersionUID = 1L;
	
	private ISA isa;
	private GS gs;
	private List<EDI997Item> itemList;
	private GE ge;
	private IEA iea;

	public GS getGs() {
		return gs;
	}

	public void setGs(GS gs) {
		this.gs = gs;
	}

	public List<EDI997Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<EDI997Item> itemList) {
		this.itemList = itemList;
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

	public ISA getIsa() {
		return isa;
	}

	public void setIsa(ISA isa) {
		this.isa = isa;
	}

private Delimiters defaultDelimiters = new Delimiters().setSegment("\n").setField("*").setComponent("^").setSubComponent("~");
	
	public void write(Writer writer) throws IOException {
		write(writer, defaultDelimiters);
	}
	
	public void write(Writer writer, Delimiters delimiters) throws IOException {
		if(writer != null && delimiters != null){
			if(isa != null){
				isa.write(writer, delimiters);
			}
			
			if(gs != null){
				gs.write(writer, delimiters);
			}
			
			if(itemList != null && !itemList.isEmpty()){
				for(EDI997Item item : itemList){
					if(item.getSt() != null){
						item.getSt().write(writer, delimiters);
					}
					
					if(item.getAk1() != null){
						item.getAk1().write(writer, delimiters);
					}
					List<EDIAKItem> ediakItems = item.getItems();
					if(ediakItems != null){
						for(EDIAKItem ediakItem:ediakItems){
							if(ediakItem.getAk2()!=null){
								ediakItem.getAk2().write(writer, delimiters);
							}
							
							if(ediakItem.getAk3()!=null){
								ediakItem.getAk3().write(writer, delimiters);
							}
							
							if(ediakItem.getAk4()!=null){
								ediakItem.getAk4().write(writer, delimiters);
							}
							
							if(ediakItem.getAk5()!=null){
								ediakItem.getAk5().write(writer, delimiters);
							}
						}
					}
					
					if(item.getAk9() != null){
						item.getAk9().write(writer, delimiters);
					}
					
					if(item.getSe() != null){
						item.getSe().write(writer, delimiters);
					}
				}
			}
			
			if(ge != null){
				ge.write(writer, delimiters);
			}
			
			if(iea != null){
				iea.write(writer, delimiters);
			}
		}
	}
}
