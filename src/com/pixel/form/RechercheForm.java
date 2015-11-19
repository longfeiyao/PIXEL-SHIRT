package com.pixel.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pixel.exceptions.FormValidationException;

public class RechercheForm extends Form{
	
	public List<String> getSearch(HttpServletRequest request){
		List<String> taglist = new ArrayList<>();
		String tag = getValeurChamp(request, CHAMP_TAGS);
		
		try {
			taglist = traiterTags(tag);
		} catch (FormValidationException e) {
			setErreur(CHAMP_TAGS, e.getMessage());
		}
		return taglist;
	}

}
