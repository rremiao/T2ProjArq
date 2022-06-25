package com.rremiao.vendaService.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.Gson;
import com.rremiao.vendaService.business.dto.EnderecoDTO;
import com.rremiao.vendaService.business.dto.ItemCarrinhoDTO;
import com.rremiao.vendaService.business.dto.ParamSubtotal_DTO;
import com.rremiao.vendaService.business.dto.PrecosDTO;
import com.rremiao.vendaService.business.dto.ProdutoDTO;
import com.rremiao.vendaService.business.dto.VendaDTO;
import com.rremiao.vendaService.business.entity.Venda;
import com.rremiao.vendaService.core.operation.VendaOperationRepository;
import com.rremiao.vendaService.core.service.MSIntegrationService;

@Repository
public class VendaRepository {

    @Autowired
    VendaOperationRepository vendaOperationRepository;

    @Autowired
    MSIntegrationService integrationService;

    public boolean confirmaVenda(final List<ItemCarrinhoDTO> itens) {

        List<ProdutoDTO> listaProdutos = integrationService.listaProdutos();
        ArrayList<Integer> listaQtdades = new ArrayList<>();

        List<ProdutoDTO> produtos = new ArrayList<>();

        for (ItemCarrinhoDTO item : itens) {
            final ProdutoDTO produto = listaProdutos.stream().filter(p -> p.getCodigo() == item.getCodigo()).findAny()
                    .orElse(null);

            if (produto == null) {
                return false;
            }

            listaQtdades.add(item.getQuantidade());
            produtos.add(produto);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < produtos.size(); i++) {
            final ProdutoDTO produto = produtos.get(i);
            final int qtdade = listaQtdades.get(i);
            produto.saidaDeProduto(qtdade);

            builder.append(produto.getCodigo());
            builder.append(" ");
            builder.append(produto.getDescricao());
            builder.append(" ");
            builder.append(qtdade);
            builder.append("\n");
        }

        Venda venda = new Venda();
        
        venda = venda.withDesconto(0)
                     .withImposto(integrationService.calculaImpostoSimples(produtos))
                     .withValorTotal(calculaValorTotal(itens))
                     .withFrete(25)
                     .withEndereco(1)
                     .withItemsCarrinhoJson(mapearJson(itens));
        
        vendaOperationRepository.save(venda);
        return true;
    }

    public PrecosDTO calculaSubtotal(final ParamSubtotal_DTO param) {
        Integer subtotal = 0;
        Integer imposto = 0;
        PrecosDTO response = new PrecosDTO();
        List<ProdutoDTO> produtos = integrationService.listaProdutos();

        //Verifica se o endereço existe
        if (param.getEndereco() == null ||
            param.getEndereco().isEmpty() ||
            param.getEndereco().isBlank()) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereco invalido");
       } 

        for (final ItemCarrinhoDTO it : param.getItens()) {
            // Procurar o produto pelo código
            final ProdutoDTO prod = produtos.stream().filter(p -> p.getCodigo() == it.getCodigo()).findAny()
                    .orElse(null);

            if (prod != null) {
                subtotal += (int) (prod.getPreco() * it.getQuantidade());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }
        }
        
        double frete = 25.0;

        response.withSubtotal(subtotal)
                .withImposto(imposto)
                .withTotal(subtotal + imposto + frete);

        return response;
    }

    public List<VendaDTO> listaVenda() {
        List<Venda> listaDeVendas = vendaOperationRepository.findAll();
        List<VendaDTO> lista = new ArrayList<>();

        for(Venda venda : listaDeVendas) {
            VendaDTO vnda = new VendaDTO();
            EnderecoDTO addr = integrationService.buscaEndereco(venda.getEndereco());

            vnda.withId(venda.getId())
                    .withFrete(venda.getFrete())
                    .withImposto(venda.getImposto())
                    .withDesconto(venda.getDesconto())
                    .withItemsCarrinho(venda.getItemsCarrinhoJson())
                    .withValorTotal(venda.getValorTotal())
                    .withEndereco(addr);
            
            lista.add(vnda);
        }

        return lista;
    }


    private int calculaValorTotal(List<ItemCarrinhoDTO> itens) {
        int soma = 0;

        for(ItemCarrinhoDTO item : itens) {
            int desconto = (int)item.getDesconto();
            int imposto = (int) item.getImposto();
            int custo = (int) item.getCusto();

            int calculo = (imposto + custo) - desconto;

            soma+= calculo;
        }

        return soma;
    }
    
    private String mapearJson(List<ItemCarrinhoDTO> itens) {
        String json = "";
        Gson gson = new Gson();

        for(ItemCarrinhoDTO item : itens) {
            json.concat(gson.toJson(item));
        }

        return json;
    }
}
