package br.com.caelum.vraptor.actions.api.action;

import br.com.caelum.vraptor.actions.api.db.IModel;
import br.com.caelum.vraptor.serialization.Serializer;

public interface PersistAction extends Activity {

	<T> PersistAction insert(T object);
	
	<T> PersistAction update(T object);

	PersistAction save(IModel object);

	<T> T andReturn();

	<T> T redirectTo(T controller);

	<T> T redirectTo(Class<T> controller);
	
	Serializer json();
	
	Serializer jsonWithoutRoot();

}
