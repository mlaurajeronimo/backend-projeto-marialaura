package com.minhabagagem.minhabagagem.controller;

import com.minhabagagem.minhabagagem.model.Lugar;
import com.minhabagagem.minhabagagem.service.LugarService;
import com.minhabagagem.minhabagagem.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.minhabagagem.minhabagagem.model.ClimaDTO;
import com.minhabagagem.minhabagagem.model.ClimaComSugestaoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;


@RestController
@RequestMapping("/lugares")
public class LugarController {

    @Autowired
    private LugarService lugarService;

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public String adicionarLugar(@RequestBody Lugar lugar) {
        lugarService.adicionarLugar(lugar);
        return "Lugar adicionado com sucesso!";
    }

    @GetMapping
    public List<Lugar> listarLugares() {
        return lugarService.listarLugares();
    }

    @GetMapping("/sobre")
    public Map<String, Object> sobre() {
        return Map.of(
                "integrante", List.of("Maria Laura Jeronimo"),
                "nome_projeto", "minhabagagem"
        );
    }

    @GetMapping("/buscar")
    public List<Lugar> buscarPorNome(@RequestParam String nome) {
        return lugarService.buscarPorNome(nome);
    }

    @PutMapping("/{nome}")
    public String editarLugar(@PathVariable String nome, @RequestBody Lugar novoLugar) {
        boolean editado = lugarService.editarLugar(nome, novoLugar);
        return editado ? "Lugar editado com sucesso!" : "Lugar não encontrado!";
    }

    @DeleteMapping("/{nome}")
    public String deletarLugar(@PathVariable String nome) {
        boolean deletado = lugarService.deletarLugar(nome);
        return deletado ? "Lugar deletado com sucesso!" : "Lugar não encontrado!";
    }

    @GetMapping("/mala")
    public Map<String, Object> sugestaoDeMala(@RequestParam String cidade) {
        ClimaDTO clima = weatherService.buscarClima(cidade);

        double temperatura = clima.getTemperatura();

        List<String> itens;

        if (temperatura < 10) {
            itens = List.of("Casaco grosso", "Gorro ou Touca de lã", "Luvas", "Cachecol", "Botas impermeáveis e forradas");
        } else if (temperatura < 20) {
            itens = List.of("É interessante adicionar na sua mala:","Casaco leve", "Calça jeans", "Tênis", "Suéter ou cardigã", "Blusa de moletom");
        } else if (temperatura < 30) {
            itens = List.of("É interessante adicionar na sua mala:","Camiseta", "Shorts", "Chinelo", "Óculos de sol");
        } else {
            itens = List.of("É interessante adicionar na sua mala:","Roupas leves", "Protetor solar", "Chapéu ou boné", "Saias ou vestidos leves");
        }

        return Map.of(
                "cidade", clima.getCidade(),
                "temperatura", temperatura,
                "descricao", clima.getDescricao(),
                "itens_para_levar", itens
        );
    }

    @GetMapping("/clima/sugestao")
    public ClimaComSugestaoDTO obterClimaComSugestao(@RequestParam String cidade) {
        return weatherService.buscarClimaComSugestao(cidade);
    }

    @PostMapping("/clima")
    public ClimaComSugestaoDTO obterClimaViaPost(@RequestBody Map<String, String> body) {
        String cidade = body.get("cidade");
        return weatherService.buscarClimaComSugestao(cidade);
    }



}
