/*
 * Created on 20.Tem.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.utility;

/**
 * @author can
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MessageUtility {

	public static final String getMessage(Object messageKey) {
		
		ResourceUtility util = new ResourceUtility("formtext_tr");
		
		if (messageKey == null) {
			return util.getValue("Message.unknown");
		} else {
			return util.getValue(String.valueOf(messageKey));
		}

	}

}
