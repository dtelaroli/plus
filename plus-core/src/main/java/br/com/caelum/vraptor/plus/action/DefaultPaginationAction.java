package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;

public class DefaultPaginationAction extends AbstractAction implements PaginationAction {

	private int page = 0;
	private int limit = 20;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPaginationAction() {
		this(null, null);
	}
	
	@Inject
	public DefaultPaginationAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> List<T> all(Class<T> type) {
		return db().use(find()).paginate(type, page, limit);
	}

	@Override
	public PaginationAction page(int page) {
		result().include("page", page);
		this.page = page;
		return this;
	}

	@Override
	public PaginationAction limit(int limit) {
		result().include("limit", limit);
		this.limit = limit;
		return this;
	}

}
