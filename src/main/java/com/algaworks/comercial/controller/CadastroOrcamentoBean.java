package com.algaworks.comercial.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.service.GestaoOrcamentos;

@Named
@ViewScoped
public class CadastroOrcamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Orcamento orcamento = new Orcamento();
	
	private OrcamentoItem orcamentoItem;
	
	@Inject
	private GestaoOrcamentos gestaoOrcamentos;
	
	public void salvar() {
		gestaoOrcamentos.salvar(orcamento);
		FacesMessage message = new FacesMessage("Orçamento salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		orcamento = new Orcamento();
	}
	
	public void adicionarItem() {
		orcamento.getItens().add(orcamentoItem);
		orcamentoItem.setOrcamento(orcamento);
	}
	
	public void novoItem() {
		orcamentoItem = new OrcamentoItem();
	}
	
	public OrcamentoItem getOrcamentoItem() {
		return orcamentoItem;
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
}
