package br.com.caelum.vraptor.actions.core.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.Db;
import br.com.caelum.vraptor.actions.api.action.DeleteAction;
import br.com.caelum.vraptor.validator.Validator;

@Vetoed
public class MockDeleteAction extends AbstractMock implements DeleteAction {

	public MockDeleteAction() {
		super();
	}

	public MockDeleteAction(Result result, Db db, Validator validator) {
		super(result, db, validator);
	}

	@Override
	public <T> DeleteAction by(Class<T> type, Object id) {
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T andReturn() {
		Object object = get(Integer.class);
		if(object == null) {
			return (T) Integer.valueOf(0);
		}
		return (T) object;
	}
	
}
