package project.rasvetov.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.rasvetov.dto.ItemPedidoDto;
import project.rasvetov.dto.PedidoDto;
import project.rasvetov.exceptions.RegraNegocioException;
import project.rasvetov.model.Cliente;
import project.rasvetov.model.ItemPedido;
import project.rasvetov.model.Pedido;
import project.rasvetov.model.Produto;
import project.rasvetov.repositories.ClienteRepository;
import project.rasvetov.repositories.ItemPedidoRepository;
import project.rasvetov.repositories.PedidoRepository;
import project.rasvetov.repositories.ProdutoRepository;
import project.rasvetov.services.PedidoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDto dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedido = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itemPedidoRepository.saveAll(itemPedido);
        pedido.setItens((Set<ItemPedido>) itemPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }

    private List<ItemPedido> converterItens(Pedido pedido ,List<ItemPedidoDto> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException("não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: " + idProduto
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());

    }

}
