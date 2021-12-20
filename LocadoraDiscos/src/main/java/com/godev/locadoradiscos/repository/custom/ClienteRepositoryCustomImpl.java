package com.godev.locadoradiscos.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godev.locadoradiscos.modelo.Cliente;
import com.godev.locadoradiscos.modelo.Disco;
import com.godev.locadoradiscos.modelo.QCliente;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ClienteRepositoryCustomImpl implements ClienteRespositoryCustom{

	public static final QCliente Q_CLIENTE = QCliente.cliente;
	
	private JPAQueryFactory _buildQueryFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.godev.locadoradiscos");
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
	
		return queryFactory;
	}
	
	@Override
	public List<Cliente> buscarTodosClientes(){
		List<Cliente> clientes = _buildQueryFactory().selectFrom(Q_CLIENTE).fetch();
		return clientes;
	}
	
//	@Override
//	public List<Cliente> buscarClienteDisco(Disco disco){
//		List<Cliente> clientesDisco = _buildQueryFactory().selectFrom(Q_CLIENTE)//
//				.where(Q_CLIENTE.dis)
//	}
	
	@Override
	public Cliente buscarClientePorNome(String nome) {
		QCliente cliente = QCliente.cliente;
		
		Cliente c = _buildQueryFactory().selectFrom(cliente).where(cliente.nome.eq("Marcio")).fetchOne();	
		return c;
	}
}