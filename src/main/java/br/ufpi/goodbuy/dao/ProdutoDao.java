package br.ufpi.goodbuy.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.ufpi.goodbuy.modelo.Produto;

@RequestScoped
public class ProdutoDao {

	private final Session session;

	protected ProdutoDao() {
		this(null);
	}

	@Inject
	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void salva(final Produto produto) {
		session.saveOrUpdate(produto);
	}

	public Produto carrega(Long id) {
		return (Produto) this.session.load(Produto.class, id);
	}

	public void remove(Produto produto) {
		session.delete(produto);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaTudo() {
		return this.session.createCriteria(Produto.class).list();
	}

	public void atualiza(Produto produto) {
		session.saveOrUpdate(produto);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> busca(String nome) {
		return session.createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Produto produto) {
		session.refresh(produto);
	}

}
