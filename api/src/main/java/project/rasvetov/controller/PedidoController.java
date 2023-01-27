package project.rasvetov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project.rasvetov.dto.AtualizacaoStatusPedidoDto;
import project.rasvetov.dto.InformacaoItemPedidoDto;
import project.rasvetov.dto.InformacoesPedidoDto;
import project.rasvetov.dto.PedidoDto;
import project.rasvetov.enums.StatusPedido;
import project.rasvetov.model.ItemPedido;
import project.rasvetov.model.Pedido;
import project.rasvetov.services.PedidoService;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//classe responsável por processar as requisições e gerar respostas referente aos pedidos
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody @Valid PedidoDto dto){
        Pedido pedido =  service.salvar(dto);
        return pedido.getId();
    }

    @GetMapping("/{id}")
    public InformacoesPedidoDto getById(@PathVariable Integer id){
        return service
                .obterPedidoCompleto(id)
                .map(p -> converter(p))
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND , "Pedido não encontrado."));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Integer id, @RequestBody AtualizacaoStatusPedidoDto dto){
        String novoStatus = dto.getNovoStatus();
        service.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
    }


    private InformacoesPedidoDto converter(Pedido pedido){
        return InformacoesPedidoDto
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .itens(converter((List<ItemPedido>) pedido.getItens()))
                .build();
    }

    private List<InformacaoItemPedidoDto> converter(List<ItemPedido> itens){
        if(CollectionUtils.isEmpty(itens)){
            return Collections.emptyList();
        }

        return itens.stream().map(
                item -> InformacaoItemPedidoDto
                .builder().descricaoProduto(item.getProduto().getDescricao())
                        .precoUnitario(item.getProduto().getPreco())
                        .quantidade(item.getQuantidade())
                        .build()
        ).collect(Collectors.toList());
    }

}
