package br.com.caelum.vraptor.actions.api;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.actions.api.action.DeleteAction;
import br.com.caelum.vraptor.actions.api.action.ListAction;
import br.com.caelum.vraptor.actions.api.action.LoadAction;
import br.com.caelum.vraptor.actions.api.action.PaginationAction;
import br.com.caelum.vraptor.actions.api.action.PersistAction;
import br.com.caelum.vraptor.actions.api.service.EmailAction;
import br.com.caelum.vraptor.actions.api.service.SessionAction;

@Vetoed
public class Acts {

	public static Class<ListAction> list() {
		return ListAction.class;
	}

	public static Class<LoadAction> load() {
		return LoadAction.class;
	}
	
	public static Class<PersistAction> persist() {
		return PersistAction.class;
	}

	public static Class<PaginationAction> pagination() {
		return PaginationAction.class;
	}

	public static Class<DeleteAction> delete() {
		return DeleteAction.class;
	}
	
	public static Class<SessionAction> session() {
		return SessionAction.class;
	}
	
	public static Class<EmailAction> email() {
		return EmailAction.class;
	}

}
