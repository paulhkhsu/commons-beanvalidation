package com.experian.cis.commons.beanvalidation.test;
/*
 * @author Paul Hsu
 */
import com.experian.cis.commons.beanvalidation.intf.IUniqueValidateCheck;

public class UniqueCheckTest implements IUniqueValidateCheck {

	@Override
	public boolean isUnique(Object o) {
		
		if(o instanceof String){
			if(((String) o).equals("uniqueid"))
				return true;
			
		}
		return false;
	}

}
