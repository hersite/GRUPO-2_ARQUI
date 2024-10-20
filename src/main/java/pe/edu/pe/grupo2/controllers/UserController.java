package pe.edu.pe.grupo2.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.CantidadNotiUsuarioDTO;
import pe.edu.pe.grupo2.dtos.UserCentroReciclajeDTO;
import pe.edu.pe.grupo2.dtos.UserDTO;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.serviceinterfaces.UserService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class UserController {
    @Autowired
    private UserService uS;

    @PostMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.insert(ur);
    }
    
    @GetMapping
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserDTO> listar() {

        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public UserDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uS.listId(id),UserDTO.class);
        return dto;
    }
    @PutMapping
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User ur = m.map(dto, User.class);
        uS.update(ur);
    }
    @DeleteMapping("/{id}")
    //  @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void eliminar(@PathVariable("id")Integer id) {
        uS.delete(id);
    }

    @GetMapping("/busquedas")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserDTO> buscar(@RequestParam String genero) {

        return uS.BuscarGenero(genero).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}/centros-reciclaje")
    //  @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclaje(@PathVariable("id") Integer idUser) {
        return uS.obtenerUsuarioConCentrosDeReciclaje(idUser);
    }
    @GetMapping("/centros-reciclaje-filtrados")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UserCentroReciclajeDTO> obtenerUsuarioConCentrosDeReciclajeFiltrado(
            @RequestParam(required = false) int edad,
            @RequestParam(required = false) Boolean favoritos) {

        return uS.obtenerUsuarioConCentrosDeReciclajeFavorito(favoritos);
    }
    @GetMapping("/conteo_notificaciones_rangoHoras")
    //   @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<CantidadNotiUsuarioDTO> Cantidadnotificaciones_deusuario_rangohoras(@RequestParam LocalDate diaInicio, @RequestParam LocalDate diaFin) {
        List<String[]> filaLista = uS.Cantidadnotificaciones_deusuario_rangohoras(diaInicio, diaFin);
        List<CantidadNotiUsuarioDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            CantidadNotiUsuarioDTO dto = new CantidadNotiUsuarioDTO();
            dto.setNombres(columna[0]);
            dto.setCantidad_notif(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
