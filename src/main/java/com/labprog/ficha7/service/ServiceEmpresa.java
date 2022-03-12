package com.labprog.ficha7.service;

import com.labprog.ficha7.model.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpresa {
    private List<Empresa> empresas;

    public Empresa addEmpresa(Empresa empresa) {
        empresas.add(empresa);
        return empresa;
    }

    public Empresa updateEmpresa(Empresa empresa) throws Exception {
        for (Empresa empresaDb : empresas) {
            if (empresaDb.getId() == empresa.getId()) {
                if (empresa.getNome() != null && !empresa.getNome().isBlank()) {
                    empresaDb.setNome(empresa.getNome());
                }
                if (empresa.getMorada() != null && !empresa.getMorada().isBlank()) {
                    empresaDb.setMorada(empresa.getMorada());
                }
                return empresa;
            }
        }

        throw new Exception("Empresa Inexistente");
    }

    public boolean deleteEmpresa(String id) {
        int empresaId = Integer.parseInt(id);

        for (Empresa empresa : empresas) {
            if (empresa.getId() == empresaId) {
                empresas.remove(empresa);
                return true;
            }
        }
        return false;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public Empresa getEmpresa(String id) throws Exception {
        int empresaId = Integer.parseInt(id);
        for (Empresa empresa : empresas) {
            if (empresa.getId() == empresaId) {
                return empresa;
            }
        }
        throw new Exception("Empresa com id " + id + " inexistente.");
    }
}
