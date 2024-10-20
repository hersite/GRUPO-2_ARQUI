package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    public List<User> list();
    public void insert(User u);

    public User listId(int id);
    public void update(User u);
    public void delete(int id);
    public List<User> BuscarGenero(String genero);
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclaje(int idUser);
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclajeFavorito(Boolean favoritos);
//<<<<<<< Updated upstream
//=======
    public List<String[]> Cantidadnotificaciones_deusuario_rangohoras(LocalDate horaInicio, LocalDate horaFin);
}
