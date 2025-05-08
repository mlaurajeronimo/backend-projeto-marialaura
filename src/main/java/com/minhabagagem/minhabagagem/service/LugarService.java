package com.minhabagagem.minhabagagem.service;

import com.minhabagagem.minhabagagem.model.Lugar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LugarService {

    private List<Lugar> lugares = new ArrayList<>();

    public void adicionarLugar(Lugar lugar) {
        lugares.add(lugar);
    }

    public List<Lugar> listarLugares() {
        return lugares;
    }

    public List<Lugar> getTodosLugares() {
        return lugares;
    }

    public List<Lugar> buscarPorNome(String nome) {
        return lugares.stream()
                .filter(lugar -> lugar.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public boolean editarLugar(String nome, Lugar novoLugar) {
        for (int i = 0; i < lugares.size(); i++) {
            if (lugares.get(i).getNome().equalsIgnoreCase(nome)) {
                lugares.set(i, novoLugar);
                return true;
            }
        }
        return false;
    }

    public boolean deletarLugar(String nome) {
        return lugares.removeIf(lugar -> lugar.getNome().equalsIgnoreCase(nome));
    }
}
