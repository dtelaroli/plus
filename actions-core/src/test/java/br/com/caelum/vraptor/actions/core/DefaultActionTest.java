package br.com.caelum.vraptor.actions.core;

import static br.com.caelum.vraptor.actions.api.Actions.list;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.action.ListAction;
import br.com.caelum.vraptor.actions.core.DefaultAction;
import br.com.caelum.vraptor.actions.core.DefaultListAction;
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Validator;

public class DefaultActionTest {

	private Act act;
	@Mock private Container container;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(container.instanceFor(list())).thenReturn(new DefaultListAction());
		when(container.instanceFor(Result.class)).thenReturn(new MockResult());
		when(container.instanceFor(Validator.class)).thenReturn(new MockValidator());
		
		act = new DefaultAction(container);
	}

	@Test
	public void shouldReturnListAllActionInstance() {
		assertThat(act.as(list()), instanceOf(ListAction.class));
	}
	
	@Test
	public void shouldReturnResultInstance() {
		assertThat(act.result(), instanceOf(Result.class));
	}

}
