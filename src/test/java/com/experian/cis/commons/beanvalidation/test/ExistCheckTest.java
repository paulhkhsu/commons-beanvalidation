package com.experian.cis.commons.beanvalidation.test;
/*
 * @author Paul Hsu
 */
import com.experian.cis.commons.beanvalidation.intf.IExistValidateCheck;

public class ExistCheckTest implements IExistValidateCheck {

	@Override
	public boolean isExist(Object o) {
		// TODO Auto-generated method stub
		//System.out.println("validate " + o);
		
		if(o instanceof String){
			if(((String) o).equals("exist"))
				return true;
		}
		return false;
	}

}
