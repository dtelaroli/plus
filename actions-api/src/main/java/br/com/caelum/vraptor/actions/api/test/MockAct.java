package br.com.caelum.vraptor.actions.api.test;

import java.util.List;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.Action;
import br.com.caelum.vraptor.actions.api.Db;
import br.com.caelum.vraptor.actions.api.action.DeleteAction;
import br.com.caelum.vraptor.actions.api.action.ListAction;
import br.com.caelum.vraptor.actions.api.action.LoadAction;
import br.com.caelum.vraptor.actions.api.action.PaginationAction;
import br.com.caelum.vraptor.actions.api.action.PersistAction;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Validator;

@Vetoed
public class MockAct extends AbstractMock implements Act {
	
	private MockPaginationAction mockPagination;
	private MockListAction mockList;
	private MockLoadAction mockLoad;
	private MockPersistAction mockPersist;
	private MockDeleteAction mockDelete;
	
	public MockAct() {
		this(new MockResult());
	}
	
	public MockAct(Result result) {
		this(result, null, new MockValidator());
	}
	
	public MockAct(Result result, Db db, Validator validator) {
		super(result, db, validator);
		mockPagination = new MockPaginationAction(result, db, validator);
		mockList = new MockListAction(result, db, validator);
		mockLoad = new MockLoadAction(result, db, validator);
		mockPersist = new MockPersistAction(result, db, validator);
		mockDelete = new MockDeleteAction(result, db, validator);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Action> T as(Class<T> act) {
		if(act.isAssignableFrom(PaginationAction.class)) {
			return (T) mockPagination;
		}
		else if(act.isAssignableFrom(ListAction.class)) {
			return (T) mockList;
		}
		else if(act.isAssignableFrom(LoadAction.class)) {
			return (T) mockLoad;
		}
		else if (act.isAssignableFrom(PersistAction.class)) {
			return (T) mockPersist;
		}
		else if(act.isAssignableFrom(DeleteAction.class)) {
			return (T) mockDelete;
		}
		return proxy(act);
	}

	public MockAct returning(Object obj) {
		Class<? extends Object> type = obj.getClass();
		if(obj instanceof List) {
			List<?> list = (List<?>) obj;
			if(list != null && !list.isEmpty()) {
				type = getType(type, list);
			}
		}
		else if(obj instanceof Page) {
			List<?> list = ((Page<?>) obj).getList();
			if(list != null && !list.isEmpty()) {
				type = getType(type, list);
			}
		}
		
		mockList.putReturn(type, obj);
		mockPagination.putReturn(type, obj);
		mockLoad.putReturn(type, obj);
		mockPersist.putReturn(type, obj);
		mockDelete.putReturn(type, obj);
		return this;
	}

	private Class<? extends Object> getType(Class<? extends Object> type,
			List<?> list) {
		Object item = list.get(0);
		if(item != null) {
			type = item.getClass();
		}
		return type;
	}

}
