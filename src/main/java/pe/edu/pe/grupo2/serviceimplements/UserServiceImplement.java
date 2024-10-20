package pe.edu.pe.grupo2.serviceimplements;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.UserRepository;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;


import java.time.LocalDate;
import java.util.List;
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }

    @Override
    public void insert(User u) {
        uR.save(u);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }

    @Override
    public void update(User u) {
        uR.save(u);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);

    }

    @Override
    public List<User> BuscarGenero(String genero) {
        return uR.BuscarGenero(genero);
    }

    @Override
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclaje(int idUser) {
        return uR.obtenerUsuarioConCentrosDeReciclaje(idUser);
    }
    @Override
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclajeFavorito(Boolean favoritos) {
        return uR.findUserWithCentrosReciclajeFiltered(favoritos);
    }

    @Override
    public List<String[]> Cantidadnotificaciones_deusuario_rangohoras(LocalDate horaInicio, LocalDate horaFin) {
        return uR.Cantidadnotificaciones_deusuario_rangohoras(horaInicio, horaFin);
    }


}
