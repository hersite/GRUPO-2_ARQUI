package pe.edu.pe.grupo2.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Recompensas;
import pe.edu.pe.grupo2.repositories.IRecompensasRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IRecompensasService;

import java.util.List;

@Service
public class RecompensasServiceImplements implements IRecompensasService {
    @Autowired
    private IRecompensasRepository rR;

    @Override
    public void insert(Recompensas recompensas) {
        rR.save(recompensas);
    }

    @Override
    public List<Recompensas> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int idRecompensas) {
        rR.deleteById(idRecompensas);
    }

    @Override
    public Recompensas listId(int idRecompensas) {
        return rR.findById(idRecompensas).orElse(new Recompensas());
    }

    @Override
    public void update(Recompensas recompensas) {
        rR.save(recompensas);
    }

    @Override
    public List<String[]> cantidadRecompensas() {
        return rR.cantidadRecompensas();
    }

    @Override
    public List<String[]> proximoVencimiento() {
        return rR.proximoVencimiento();
    }
}
