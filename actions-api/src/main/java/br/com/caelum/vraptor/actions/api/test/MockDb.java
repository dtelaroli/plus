package br.com.caelum.vraptor.actions.api.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.actions.api.Action;
import br.com.caelum.vraptor.actions.api.Database;
import br.com.caelum.vraptor.actions.api.Db;

@Vetoed
public class MockDb extends AbstractMock implements Db {

	@Override
	public <T extends Database> T use(Class<T> db) {
		return getProxifier().proxify(db, returnOnFinalMethods(db));
	}

	@Override
	public Action returning(Object obj) {
		return this;
	}
	
}
